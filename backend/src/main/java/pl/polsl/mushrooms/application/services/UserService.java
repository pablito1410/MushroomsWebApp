package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
import pl.polsl.mushrooms.application.commands.user.DeleteUsersCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateProfileImageCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateUserCommand;
import pl.polsl.mushrooms.application.model.User;

import java.util.Optional;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface UserService {

    long handle(CreateUserCommand command);

    User handle(UpdateUserCommand command);

    void handle(DeleteUsersCommand command);

    Optional<User> getUserByEmail(String email);

    void handle(UpdateProfileImageCommand updateProfileImageCommand);
}
