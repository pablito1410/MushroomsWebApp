package pl.polsl.mushrooms.application.commands.trip;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class DeleteTripCommand implements VoidCommand {

    private String userName;

    @NotNull
    private long id;

    protected DeleteTripCommand() { }

    public DeleteTripCommand(long tripId) {
        this.id = tripId;
    }

    public long getTripId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
