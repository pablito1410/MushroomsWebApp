package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
import pl.polsl.mushrooms.application.commands.user.DeleteUserCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateUserCommand;
import pl.polsl.mushrooms.application.model.User;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface UserService {

    UUID handle(CreateUserCommand command);

    void handle(UpdateUserCommand command);

    void handle(DeleteUserCommand command);

    Optional<User> getUserByEmail(String email);
}
