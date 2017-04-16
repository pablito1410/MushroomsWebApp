package pl.polsl.mushrooms.application.services;

import org.springframework.data.domain.Sort;
import pl.polsl.mushrooms.application.commands.CreateUserCommand;
import pl.polsl.mushrooms.application.commands.GetUserCommand;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.exceptions.UserAlreadyExistException;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.application.model.UserProfile;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class UserServiceImpl implements UserService {


    private final UserDao repo;

    public UserServiceImpl(UserDao repo) {

        this.repo = repo;
    }
    @Override
    public Long handle(CreateUserCommand command) {
        if (userExist(command.getEmail())) {
            throw new UserAlreadyExistException("User with an e-mail = " + command.getEmail() + " already exist.");
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

        return user.getId();
    }

    @Override
    public UserProfile handle(GetUserCommand command) {

        Optional<User> user = Optional.ofNullable(repo.findUser(command.getId()));

        if (user.isPresent()) {
            return new UserProfile(
                    user.get().getId(),
                    user.get().getNick(),
                    user.get().getEmail(),
                    user.get().getAge(),
                    user.get().getGender(),
                    user.get().getRole()
            );
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
