package pl.polsl.mushrooms.application.commands;


import pl.polsl.mushrooms.application.model.User;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 17.04.2017.
 */
public class GetUserCommand implements ReturningCommand<User> {

    private UUID id;

    private GetUserCommand() { }

    public GetUserCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
