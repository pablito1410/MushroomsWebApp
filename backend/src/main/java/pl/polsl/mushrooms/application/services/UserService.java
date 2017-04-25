package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.*;
import pl.polsl.mushrooms.application.model.User;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface UserService {

    UUID handle(CreateUserCommand command);

    User handle(GetUserCommand command);

    Optional<User> getUserByEmail(String email);

    Collection<User> handle(GetAllUsersCommand command);

    void handle(UpdateUserCommand updateUserCommand);

    void handle(DeleteUserCommand deleteUserCommand);
}
