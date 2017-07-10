package pl.polsl.mushrooms.application.commands.trip;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 27.06.2017.
 */
public class InviteToTripCommand implements VoidCommand {

    private String userName;

    @NotNull
    private Long[] userIds;

    @NotNull
    private Long tripId;


    private String currentUsername;

    protected InviteToTripCommand() { }

    public Long[] getUserIds() {
        return userIds;
    }

    public Long getTripId() {
        return tripId;
    }

    public String getCurrentUsername() {
        return currentUsername;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
