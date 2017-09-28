package pl.polsl.mushrooms.application.commands.discovery;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.polsl.mushrooms.application.commands.VoidCommand;
import pl.polsl.mushrooms.infrastructure.tools.deserializers.LocalDateTimeDeserializer;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;

public class UpdateDiscoveryCommand implements VoidCommand {

    private String userName;

    @NotNull
    private Long id;
    @NotNull
    private Long mushroomSpeciesId;
    @NotNull
    private Double coordinateX;
    @NotNull
    private Double coordinateY;
    @NotNull
    private byte[] photo;

    @NotNull
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateTime;

    private Collection<String> tags;

    @NotNull
    private Boolean isPublic;

    protected UpdateDiscoveryCommand() { }

    public String getUserName() {
        return userName;
    }

    public Long getId() {
        return id;
    }

    public Long getMushroomSpeciesId() {
        return mushroomSpeciesId;
    }

    public Double getCoordinateX() {
        return coordinateX;
    }

    public Double getCoordinateY() {
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

    public Boolean isPublic() {
        return isPublic;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}