package pl.polsl.mushrooms.application.user;

import pl.polsl.mushrooms.application.user.command.CreateUserCommand;
import pl.polsl.mushrooms.application.user.presentation.UserProfilePresentation;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface UserService {

    UserProfilePresentation handle(CreateUserCommand command);
}
