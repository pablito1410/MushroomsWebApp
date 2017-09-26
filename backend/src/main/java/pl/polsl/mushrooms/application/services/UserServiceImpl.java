package pl.polsl.mushrooms.application.services;

import org.springframework.beans.factory.annotation.Autowired;
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
import pl.polsl.mushrooms.application.tools.PasswordEncoder;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.Optional;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final EntityMapper entityMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(
            final UserDao userDao,
            final EntityMapper entityMapper,
            final PasswordEncoder passwordEncoder) {

        this.userDao = userDao;
        this.entityMapper = entityMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public long handle(CreateUserCommand command) {
        if (emailExist(command.getEmail())) {
            throw new EntityAlreadyExistException(
                    "User with an e-mail = " + command.getEmail() + " already exist.");
        }

        if (userNameExist(command.getUsername())) {
            throw new EntityAlreadyExistException(
                    "User with an userName = " + command.getUsername() + " already exist.");
        }

        final String encodedPassword = passwordEncoder.encode(command.getPassword());

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
        return userDao.findOneByEmail(email);
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
    public User getUserByName(final String userName) {
        return userDao.findOneByUsername(userName)
                .orElseThrow(NoRequiredPermissions::new);
    }

    @Override
    public UserDto handle(UpdateUserCommand command) {
        final String currentUserName = command.getCurrentUserName();
        final User currentUser = userDao.findOneByUsername(currentUserName)
                .orElseThrow(() -> {
                    return new EntityNotFoundException(String.format("User with username=%s not found", currentUserName));
                });

        switch (currentUser.getRole())
        {
            case ADMIN:
                final Long id = command.getId();
                final User user = userDao.findOne(id.longValue())
                        .orElseThrow(() -> {
                            return new EntityNotFoundException(String.format("User with id=%s not found", id));
                        });
                return updateUser(user, command);

            case MUSHROOMER:
                return updateUser(currentUser, command);

            default:
                return entityMapper.map(currentUser);
        }
    }

    private UserDto updateUser(final User user, UpdateUserCommand command) {
        user.setUsername(command.getUsername());
        user.setEmail(command.getEmail());

        if (user.isMushroomer()) {
            final Mushroomer mushroomer = (Mushroomer)user;
            mushroomer.setUsername(command.getUsername());
            mushroomer.setEmail(command.getEmail());
            mushroomer.setFirstName(command.getFirstName());
            mushroomer.setLastName(command.getLastName());
            mushroomer.setBirthDate(command.getBirthDate());
            mushroomer.setGender(command.getGender());
            mushroomer.setCity(command.getCity());
            mushroomer.setCountry(command.getCountry());
        }

        userDao.save(user);

        return entityMapper.map(user);
    }

    @Override
    public void handle(DeleteUsersCommand command) {
        final String currentUsername = command.getUserName();
        final User currentUser = userDao.findOneByUsername(currentUsername)
                    .orElseThrow(EntityNotFoundException::new);

        if (!currentUser.isAdmin()) {
            throw new NoRequiredPermissions("Admin permissions required");
        }

        if (command.getIds() == null) {
            throw new BadRequestException("ids is null");
        }

//        final String encodedAdminPassword = passwordEncoder.encode(command.getAdminPassword());
//
//        if (!passwordEncoder.matches(currentUser.getPassword(), encodedAdminPassword)) {
//            throw new NoRequiredPermissions("Admin permissions required");
//        }

        for (long id : command.getIds()) {
            userDao.delete(id);
        }
    }

    @Transactional(readOnly = true)
    private boolean emailExist(final String email) {
        return userDao.findOneByEmail(email).isPresent();
    }

    private boolean userNameExist(String username) {
        return userDao.findOneByUsername(username).isPresent();
    }
}
