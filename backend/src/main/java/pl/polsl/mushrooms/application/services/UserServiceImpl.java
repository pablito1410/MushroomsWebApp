package pl.polsl.mushrooms.application.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
import pl.polsl.mushrooms.application.commands.user.DeleteUsersCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateProfileImageCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateUserCommand;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.enums.MushroomerLevel;
import pl.polsl.mushrooms.application.exceptions.EntityAlreadyExistException;
import pl.polsl.mushrooms.application.exceptions.NoRequiredPermissions;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.NotFoundException;
import java.util.Optional;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final EntityMapper entityMapper;

    public UserServiceImpl(
            final UserDao userDao,
            final EntityMapper entityMapper) {

        this.userDao = userDao;
        this.entityMapper = entityMapper;
    }

    @Override
    public long handle(CreateUserCommand command) {
        if (userExist(command.getEmail())) {
            throw new EntityAlreadyExistException(
                    "User with an e-mail = " + command.getEmail() + " already exist.");
        }

        final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String encodedPassword = encoder.encode(command.getPassword());

        final Mushroomer user = new Mushroomer(
                command.getUsername(),
                command.getEmail(),
                encodedPassword,
                command.getFirstName(),
                command.getLastName(),
                command.getBirthDate(),
                command.getGender(),
                MushroomerLevel.BEGINNER
        );

        userDao.save(user);
        return user.getId();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userDao.findUserByEmail(email));
    }

    @Override
    public void handle(UpdateProfileImageCommand command) {
        final String username = command.getUserName();
        final Mushroomer user = (Mushroomer)userDao.findOneByUsername(username)
                    .orElseThrow(NotFoundException::new);

        user.setPhoto(command.getPhoto());
        userDao.save(user);
    }

    @Override
    public UserDto handle(UpdateUserCommand command) {
        final String username = command.getUserName();
        final User user = userDao.findOneByUsername(username)
                    .orElseThrow(NotFoundException::new);

        switch (user.getRole())
        {
            case ADMIN:
                user.setEmail(command.getEmail());
                userDao.save(user);
                return entityMapper.map(user);

            case MUSHROOMER:
                final Mushroomer mushroomer = (Mushroomer)user;
                mushroomer.setEmail(command.getEmail());
                mushroomer.setFirstName(command.getFirstName());
                mushroomer.setLastName(command.getLastName());
                mushroomer.setBirthDate(command.getBirthDate());
                mushroomer.setGender(command.getGender());
                mushroomer.setCity(command.getCity());
                mushroomer.setCountry(command.getCountry());
                userDao.save(user);
                return entityMapper.map(mushroomer);

            default:
                return entityMapper.map(user);
        }
    }

    @Override
    public void handle(DeleteUsersCommand command) {
        final String currentUsername = command.getUserName();
        final User currentUser = userDao.findOneByUsername(currentUsername)
                    .orElseThrow(EntityNotFoundException::new);

        final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String encodedAdminPassword = encoder.encode(command.getAdminPassword());

        if (!encoder.matches(currentUser.getPassword(), encodedAdminPassword)) {
            throw new NoRequiredPermissions("Admin permissions required");
        }

        for (long id : command.getIds()) {
            userDao.delete(id);
        }
    }

    @Transactional(readOnly = true)
    private boolean userExist(final String email) {
        return userDao.findUserByEmail(email) == null ? false : true;
    }
}
