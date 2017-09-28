package pl.polsl.mushrooms.application.commands.trip;

import pl.polsl.mushrooms.application.commands.VoidCommand;
import javax.validation.constraints.NotNull;

public class DeleteTripCommand implements VoidCommand {

    private String userName;

    @NotNull
    private Long id;

    protected DeleteTripCommand() { }

    public DeleteTripCommand(long tripId) {
        this.id = tripId;
    }

    public long getTripId() {
        return id.longValue();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
