package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
import pl.polsl.mushrooms.application.commands.user.DeleteUsersCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateUserCommand;
import pl.polsl.mushrooms.application.enums.Gender;

import java.util.Date;

/**
 * Created by pawel_zaqkxkn on 30.07.2017.
 */
class UserServiceTestUtil {

    private UserServiceTestUtil() { }

    static CreateUserCommand createUserCommand(
            final String email,
            final String userName
    ) {
        return new CreateUserCommand(
                userName,
                email,
                "password1",
                "John",
                "Kowalski",
                new Date(),
                Gender.MALE
        );
    }

    static UpdateUserCommand updateUserCommand(final String userName) {
        final UpdateUserCommand command = new UpdateUserCommand(
                "user1@email.com",
                "Eddie",
                "Nowak",
                new Date(),
                Gender.FEMALE,
                "Warsaw",
                "Poland"
        );

        command.setCurrentUserName(userName);
        return command;
    }

    public static DeleteUsersCommand deleteUsersCommand(
            final String username,
            final String adminPassword,
            final long... ids) {

        final DeleteUsersCommand command = new DeleteUsersCommand(
                adminPassword,
                ids
        );

        command.setUserName(username);

        return command;
    }
}
