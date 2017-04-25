package pl.polsl.mushrooms.application.commands.trip;

import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.application.model.Trip;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class GetCommand implements ReturningCommand<Trip> {

    private UUID id;

    protected GetCommand() { }

    public GetCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
