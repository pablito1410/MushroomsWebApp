package pl.polsl.mushrooms.application.commands.user;

import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.application.model.User;

import java.util.Collection;

/**
 * Created by pawel_zaqkxkn on 23.04.2017.
 */
public class GetAllUsersCommand implements ReturningCommand<Collection<User>> {

    public GetAllUsersCommand() { }
}
