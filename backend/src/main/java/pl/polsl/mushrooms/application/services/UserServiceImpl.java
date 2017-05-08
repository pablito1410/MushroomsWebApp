package pl.polsl.mushrooms.application.services;

import org.springframework.data.domain.Sort;
import pl.polsl.mushrooms.application.commands.user.*;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.enums.MushroomerLevel;
import pl.polsl.mushrooms.application.exceptions.EntityAlreadyExistException;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.User;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class UserServiceImpl implements UserService {


    private final UserDao repo;

    public UserServiceImpl(UserDao userDao) {

        this.repo = userDao;
    }

    @Override
    public UUID handle(CreateCommand command) {
        if (userExist(command.getEmail())) {
            throw new EntityAlreadyExistException("User with an e-mail = " + command.getEmail() + " already exist.");
        }

        final Mushroomer user = new Mushroomer(
                command.getUsername(),
                command.getEmail(),
                command.getPassword(),
                command.getFirstName(),
                command.getLastName(),
                command.getBirthDate(),
                command.getGender(),
                MushroomerLevel.INTERMEDIATE
        );

        repo.save(user);
        return user.getId();
    }

    @Override
    public User handle(GetCommand command) {

        Optional<User> user = Optional.ofNullable(repo.findUser(command.getId()));

        if (user.isPresent()) {
//            return new UserProfile(
//                    user.get().getId(),
//                    user.get().getNick(),
//                    user.get().getEmail(),
//                    user.get().getAge(),
//                    user.get().getGender(),
//                    user.get().getRole()
//            );
            return user.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(repo.findUserByEmail(email));
    }

    @Override
    public Collection<User> handle(GetAllUsersCommand command) {
        return repo.findAllUsers(new Sort("username"));
    }

    @Override
    public void handle(UpdateCommand command) {
        final Optional<User> optionalUser = Optional.of(repo.findUser(command.getUserId()));
        final User user = optionalUser.orElseThrow(EntityNotFoundException::new);

        switch (user.getRole())
        {
            case USER:
                user.setEmail(command.getEmail());
                user.setUsername(command.getUsername());
                user.setPassword(command.getPassword());
                break;

            case ADMIN:
                user.setEmail(command.getEmail());
                user.setUsername(command.getUsername());
                user.setPassword(command.getPassword());
                break;

            case MUSHROOMER:
                final Mushroomer mushroomer = (Mushroomer)user;
                mushroomer.setEmail(command.getEmail());
                mushroomer.setUsername(command.getUsername());
                mushroomer.setPassword(command.getPassword());
                mushroomer.setFirstName(command.getFirstName());
                mushroomer.setLastName(command.getLastName());
                mushroomer.setBirthDate(command.getBirthDate());
                mushroomer.setGender(command.getGender());
                break;
        }

        repo.save(user);
    }

    @Override
    public void handle(DeleteCommand command) {

    }

    private boolean userExist(final String email) {
        if (repo.findUserByEmail(email) == null) {
            return false;
        }
        else
        {
            return true;
        }
    }
}
