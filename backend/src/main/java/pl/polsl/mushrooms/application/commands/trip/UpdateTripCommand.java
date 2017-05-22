package pl.polsl.mushrooms.application.commands.trip;

import pl.polsl.mushrooms.application.commands.VoidCommand;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class UpdateTripCommand implements VoidCommand {

    private long tripId;
    private long userId;

    protected UpdateTripCommand() { }

    public long getTripId() {
        return tripId;
    }

    public long getUserId() {
        return userId;
    }
}
