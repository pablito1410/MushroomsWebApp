package pl.polsl.mushrooms.application.commands.trip;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */
public class JoinTripCommand implements VoidCommand {

    @NotNull
    private long tripId;

    protected JoinTripCommand() { }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public long getTripId() {
        return tripId;
    }
}
