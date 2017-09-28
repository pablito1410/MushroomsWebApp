package pl.polsl.mushrooms.application.commands.trip;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.polsl.mushrooms.application.commands.VoidCommand;
import pl.polsl.mushrooms.infrastructure.tools.deserializers.LocalDateTimeDeserializer;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


public class UpdateTripCommand implements VoidCommand {

    private String userName;

    @NotNull
    private Long id;

    @NotNull
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateTime;

    @NotNull
    private String place;

    @NotNull
    private Double coordinateX;

    private Double coordinateY;

    private Double radius;

    protected UpdateTripCommand() { }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getPlace() {
        return place;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getCoordinateX() {
        return coordinateX;
    }

    public Double getCoordinateY() {
        return coordinateY;
    }

    public Double getRadius() {
        return radius;
    }
}
