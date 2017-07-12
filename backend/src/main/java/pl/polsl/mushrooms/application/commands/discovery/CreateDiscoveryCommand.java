package pl.polsl.mushrooms.application.commands.discovery;

import pl.polsl.mushrooms.application.commands.ReturningCommand;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class CreateDiscoveryCommand implements ReturningCommand<Long> {

    private String userName;

    @NotNull
    private long tripId;

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

    @NotNull
    private boolean isPublic;

    private Collection<String> tags;

    protected CreateDiscoveryCommand() { }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public long getTripId() {
        return tripId;
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

    public boolean isPublic() {
        return isPublic;
    }

    public Collection<String> getTags() {
        return tags;
    }
}
