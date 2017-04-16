package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.CreateUserCommand;
import pl.polsl.mushrooms.application.commands.GetUserCommand;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.application.model.UserProfile;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface UserService {

    Long handle(CreateUserCommand command);

    UserProfile handle(GetUserCommand command);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();


}
