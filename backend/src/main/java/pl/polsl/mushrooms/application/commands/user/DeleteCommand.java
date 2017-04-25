package pl.polsl.mushrooms.application.commands.user;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class DeleteCommand implements VoidCommand {


    private final UUID id;

    public DeleteCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
