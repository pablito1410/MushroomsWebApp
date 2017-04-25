package pl.polsl.mushrooms.application.commands.trip;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class DeleteCommand implements VoidCommand {

    private UUID id;

    protected DeleteCommand() { }

    public DeleteCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
