package pl.polsl.mushrooms.application.commands.discovery;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class UpdateDiscoveryCommand implements VoidCommand {

    @NotNull
    private long id;
    @NotNull
    private long mushroomSpieceId;
    @NotNull
    private String coordinateX;
    @NotNull
    private String coordinateY;
    @NotNull
    private byte[] photo;
    @NotNull
    private LocalDateTime dateTime;

    private String[] tags;

    protected UpdateDiscoveryCommand() { }

    public long getId() {
        return id;
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

    public String[] getTags() {
        return tags;
    }
}
