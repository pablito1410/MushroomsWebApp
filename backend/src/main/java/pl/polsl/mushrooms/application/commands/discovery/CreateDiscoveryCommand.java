package pl.polsl.mushrooms.application.commands.discovery;

import pl.polsl.mushrooms.application.commands.ReturningCommand;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class CreateDiscoveryCommand implements ReturningCommand<UUID> {

    private UUID userId;
    private UUID tripId;
    private UUID mushroomSpieceId;

    private String coordinateX;
    private String coordinateY;
    private byte[] photo;
    private LocalDateTime dateTime;

    protected CreateDiscoveryCommand() { }

    public UUID getUserId() {
        return userId;
    }

    public UUID getTripId() {
        return tripId;
    }

    public UUID getMushroomSpieceId() {
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
