package pl.polsl.mushrooms.application.commands.discovery;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class UpdateDiscoveryCommand implements VoidCommand {

    private String userName;

    @NotNull
    private long id;
    @NotNull
    private long mushroomSpieceId;
    @NotNull
    private double coordinateX;
    @NotNull
    private double coordinateY;
    @NotNull
    private byte[] photo;
    @NotNull
    private LocalDateTime dateTime;

    private Collection<String> tags;

    @NotNull
    private boolean isPublic;

    protected UpdateDiscoveryCommand() { }

    public String getUserName() {
        return userName;
    }

    public long getId() {
        return id;
    }

    public long getMushroomSpieceId() {
        return mushroomSpieceId;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Collection<String> getTags() {
        return tags;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
