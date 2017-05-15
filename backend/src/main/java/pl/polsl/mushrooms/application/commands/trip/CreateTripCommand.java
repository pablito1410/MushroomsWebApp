package pl.polsl.mushrooms.application.commands.trip;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class CreateTripCommand implements VoidCommand {

    private LocalDateTime dateTime;
    private String place;
    private UUID userId;

    protected CreateTripCommand() { }

    public String getPlace() {
        return place;
    }

    public UUID getUserId() {
        return userId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
