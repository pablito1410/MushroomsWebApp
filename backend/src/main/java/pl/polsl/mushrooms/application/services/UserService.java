package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.CreateUserCommand;
import pl.polsl.mushrooms.application.commands.LoginCommand;
import pl.polsl.mushrooms.application.model.User;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface UserService {

    User handle(CreateUserCommand command);

    String handle(LoginCommand command);

    Optional<User> getUserById(UUID id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

}
