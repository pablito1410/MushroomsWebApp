package pl.polsl.mushrooms.application.commands.discovery;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.infrastructure.tools.deserializers.LocalDateTimeDeserializer;

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
    private long mushroomSpeciesId;
    @NotNull
    private double coordinateX;
    @NotNull
    private double coordinateY;

    @NotNull
    private byte[] photo;

    @NotNull
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateTime;

    @NotNull
    private boolean isPublic;

    private Collection<String> tags;

    protected CreateDiscoveryCommand() { }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public long getTripId() {
        return tripId;
    }

    void setTripId(final long tripId) {
        this.tripId = tripId;
    }

    public long getMushroomSpeciesId() {
        return mushroomSpeciesId;
    }

    void setMushroomSpeciesId(final long mushroomSpeciesId) {
        this.mushroomSpeciesId = mushroomSpeciesId;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    void setCoordinateX(final double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    void setCoordinateY(final double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public byte[] getPhoto() {
        return photo;
    }

    void setPhoto(final byte[] photo) {
        this.photo = photo;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    void setDateTime(final LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean getIsPublic() {
        return isPublic;
    }

    void setIsPublic(final boolean aPublic) {
        isPublic = aPublic;
    }

    public Collection<String> getTags() {
        return tags;
    }

    void setTags(final Collection<String> tags) {
        this.tags = tags;
    }
}
