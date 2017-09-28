package pl.polsl.mushrooms.application.commands.trip;

import pl.polsl.mushrooms.application.commands.VoidCommand;
import javax.validation.constraints.NotNull;

public class JoinTripCommand implements VoidCommand {

    private String userName;

    @NotNull
    private long tripId;

    protected JoinTripCommand() { }

    public long getTripId() {
        return tripId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
