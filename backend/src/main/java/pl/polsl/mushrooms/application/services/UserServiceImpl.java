package pl.polsl.mushrooms.application.services;

import org.springframework.data.domain.Sort;
import pl.polsl.mushrooms.application.commands.CreateUserCommand;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.User;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class UserServiceImpl implements UserService {


    private final UserDao repo;

    public UserServiceImpl(UserDao repo) {

        this.repo = repo;
    }
    @Override
    public User handle(CreateUserCommand command) {
        if (userExist(command.getEmail())) {
            return null;
        }

        final User user = new User(
                command.getEmail(),
                command.getPassword(),
                command.getNick(),
                command.getAge(),
                command.getGender(),
                command.getRole()
        );

        repo.save(user);

        return user;
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return Optional.ofNullable(repo.findUser(id));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(repo.findUserByEmail(email));
    }

    @Override
    public Collection<User> getAllUsers() {
        return repo.findAllUsers(new Sort("email"));
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
