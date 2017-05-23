package pl.polsl.mushrooms.application.commands.discovery;

import pl.polsl.mushrooms.application.commands.ReturningCommand;

import java.time.LocalDateTime;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class CreateDiscoveryCommand implements ReturningCommand<Long> {

    private long userId;
    private long tripId;
    private long mushroomSpieceId;

    private String coordinateX;
    private String coordinateY;
    private byte[] photo;
    private LocalDateTime dateTime;

    protected CreateDiscoveryCommand() { }

    public long getUserId() {
        return userId;
    }

    public long getTripId() {
        return tripId;
    }

    public long getMushroomSpieceId() {
        return mushroomSpieceId;
    }

    public String getCoordinateX() {
        return coordinateX;
    }

    public String getCoordinateY() {
        return coordinateY;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
