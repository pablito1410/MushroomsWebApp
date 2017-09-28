package pl.polsl.mushrooms.application.commands.trip;

import pl.polsl.mushrooms.application.commands.VoidCommand;
import javax.validation.constraints.NotNull;

public class InviteToTripCommand implements VoidCommand {

    private String userName;

    @NotNull
    private Long[] userIds;

    @NotNull
    private Long tripId;

    protected InviteToTripCommand() { }

    public Long[] getUserIds() {
        return userIds;
    }

    public Long getTripId() {
        return tripId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
