package pl.polsl.mushrooms.application.commands.trip;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class UpdateTripCommand implements VoidCommand {

    private String userName;

    @NotNull
    private long tripId;
    private LocalDateTime dateTime;
    private String place;

    protected UpdateTripCommand() { }

    public long getTripId() {
        return tripId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getPlace() {
        return place;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
