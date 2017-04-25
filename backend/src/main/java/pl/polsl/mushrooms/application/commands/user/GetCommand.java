package pl.polsl.mushrooms.application.commands.user;


import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.application.model.User;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 17.04.2017.
 */
public class GetCommand implements ReturningCommand<User> {

    private UUID id;

    private GetCommand() { }

    public GetCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
