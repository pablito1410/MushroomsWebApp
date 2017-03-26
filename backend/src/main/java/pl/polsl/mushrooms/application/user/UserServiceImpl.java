package pl.polsl.mushrooms.application.user;

import pl.polsl.mushrooms.application.user.command.CreateUserCommand;
import pl.polsl.mushrooms.application.user.entity.User;
import pl.polsl.mushrooms.application.user.presentation.UserProfilePresentation;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class UserServiceImpl implements UserService {


    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {

        this.repo = repo;
    }
    @Override
    public UserProfilePresentation handle(CreateUserCommand command) {
        if (userExist(command.getEmail())) {
            return null;
        }

        final User user = new User(
                command.getEmail(),
                command.getPassword(),
                command.getNick(),
                command.getAge(),
                command.getGender()
        );

        repo.save(user);

        return new UserProfilePresentation(
                user.getId(),
                user.getNick(),
                user.getAge(),
                user.getGender()
        );
    }

    private boolean userExist(final String email) {
        if (repo.load(email) == null) {
            return false;
        }
        else
        {
            return true;
        }
    }
}
