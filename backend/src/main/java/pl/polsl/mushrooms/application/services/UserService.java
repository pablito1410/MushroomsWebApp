package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
import pl.polsl.mushrooms.application.commands.user.DeleteUsersCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateProfileImageCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateUserCommand;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;

import java.util.Optional;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface UserService {

    /**
     * Creates a new user
     * @param command
     * @return Id of the created user
     */
    long handle(CreateUserCommand command);

    /**
     * Updates the user
     * @param command
     * @return Updated user
     */
    UserDto handle(UpdateUserCommand command);

    /**
     * Deletes the user
     * @param command
     */
    void handle(DeleteUsersCommand command);

    /**
     *
     * @param email
     * @return the user with the specified email
     */
    Optional<User> getUserByEmail(String email);

    /**
     * Updates the profile image of user
     * @param updateProfileImageCommand
     */
    void handle(UpdateProfileImageCommand updateProfileImageCommand);
}
