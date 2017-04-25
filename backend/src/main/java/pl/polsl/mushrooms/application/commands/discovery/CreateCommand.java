package pl.polsl.mushrooms.application.commands.discovery;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class CreateCommand implements VoidCommand {

    private String coordinateX;
    private String coordinateY;
    private byte[] photo;
    private Date date;
    private Time time;

    private String tripId;

    private String mushroomerId;

    private String mushroomSpieceId;

    protected CreateCommand() { }

    public String getCoordinateX() {
        return coordinateX;
    }

    public String getCoordinateY() {
        return coordinateY;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
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
