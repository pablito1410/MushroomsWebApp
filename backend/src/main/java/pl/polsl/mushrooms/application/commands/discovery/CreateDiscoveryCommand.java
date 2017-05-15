package pl.polsl.mushrooms.application.commands.discovery;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class CreateDiscoveryCommand implements VoidCommand {

    private String coordinateX;
    private String coordinateY;
    private byte[] photo;
    private LocalDateTime dateTime;

    private String tripId;

    private String mushroomerId;

    private String mushroomSpieceId;

    protected CreateDiscoveryCommand() { }

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

    public UUID getTripId() {
        return UUID.fromString(tripId);
    }

    public UUID getMushroomerId() {
        return UUID.fromString(mushroomerId);
    }

    public UUID getMushroomSpieceId() {
        return UUID.fromString(mushroomSpieceId);
    }
}
