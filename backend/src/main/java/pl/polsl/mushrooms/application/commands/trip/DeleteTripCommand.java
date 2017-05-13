package pl.polsl.mushrooms.application.commands.trip;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class DeleteTripCommand implements VoidCommand {

    private UUID id;

    protected DeleteTripCommand() { }

    public DeleteTripCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
