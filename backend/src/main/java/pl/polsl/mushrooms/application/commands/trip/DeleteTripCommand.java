package pl.polsl.mushrooms.application.commands.trip;

import pl.polsl.mushrooms.application.commands.VoidCommand;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class DeleteTripCommand implements VoidCommand {

    private long id;

    protected DeleteTripCommand() { }

    public DeleteTripCommand(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
