package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.user.*;
import pl.polsl.mushrooms.application.model.User;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface UserService {

    UUID handle(CreateCommand command);

    User handle(GetCommand command);

    void handle(UpdateCommand command);

    void handle(DeleteCommand command);

    Collection<User> handle(GetAllUsersCommand command);

    Optional<User> getUserByEmail(String email);
}
