package pl.polsl.mushrooms.application.commands;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class DeleteUserCommand implements VoidCommand{


    private final UUID id;

    public DeleteUserCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
