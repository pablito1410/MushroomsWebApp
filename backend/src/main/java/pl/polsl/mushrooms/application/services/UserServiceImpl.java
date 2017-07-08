package pl.polsl.mushrooms.application.services;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
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
import pl.polsl.mushrooms.infrastructure.dto.AdminDto;
import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.NotFoundException;
import java.util.Optional;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
@Transactional
public class UserServiceImpl implements UserService {


    private final UserDao repo;
    final ModelMapper modelMapper = new ModelMapper();

    public UserServiceImpl(UserDao userDao) {

        this.repo = userDao;
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

        repo.save(user);
        return user.getId();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(repo.findUserByEmail(email));
    }

    @Override
    public void handle(UpdateProfileImageCommand command) {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        final Mushroomer user = (Mushroomer)Optional.ofNullable(
                repo.findOneByUsername(username))
                    .orElseThrow(NotFoundException::new);

        user.setPhoto(command.getPhoto());
        repo.save(user);
    }

    @Override
    public UserDto handle(UpdateUserCommand command) {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        final User user = Optional.ofNullable(
                repo.findOneByUsername(username))
                    .orElseThrow(NotFoundException::new);

        switch (user.getRole())
        {
            case ADMIN:
                user.setEmail(command.getEmail());
                repo.save(user);
                return modelMapper.map(user, AdminDto.class);

            case MUSHROOMER:
                final Mushroomer mushroomer = (Mushroomer)user;
                mushroomer.setEmail(command.getEmail());
                mushroomer.setFirstName(command.getFirstName());
                mushroomer.setLastName(command.getLastName());
                mushroomer.setBirthDate(command.getBirthDate());
                mushroomer.setGender(command.getGender());
                mushroomer.setCity(command.getCity());
                mushroomer.setCountry(command.getCountry());
                repo.save(user);
                return modelMapper.map(mushroomer, MushroomerDto.class);

            default:
                return modelMapper.map(user, UserDto.class);
        }
    }

    @Override
    public void handle(DeleteUsersCommand command) {
        final String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        final User currentUser = Optional.ofNullable(
                repo.findOneByUsername(currentUsername))
                    .orElseThrow(EntityNotFoundException::new);

        final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String encodedAdminPassword = encoder.encode(command.getAdminPassword());

        if (!encoder.matches(currentUser.getPassword(), encodedAdminPassword)) {
            throw new NoRequiredPermissions("Admin permissions required");
        }

        for (long id : command.getIds()) {
            repo.delete(id);
        }
    }

    @Transactional(readOnly = true)
    private boolean userExist(final String email) {
        return repo.findUserByEmail(email) == null ? false : true;
    }
}
