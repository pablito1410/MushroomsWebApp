package pl.polsl.mushrooms.application.commands;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class CreateTripCommand implements VoidCommand {

    private Date date;
    private Time time;
    private String place;
    private UUID userId;

    protected CreateTripCommand() { }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public UUID getUserId() {
        return userId;
    }
}
