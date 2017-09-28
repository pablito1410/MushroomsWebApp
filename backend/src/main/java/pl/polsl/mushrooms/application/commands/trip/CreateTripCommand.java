package pl.polsl.mushrooms.application.commands.trip;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.infrastructure.tools.deserializers.LocalDateTimeDeserializer;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CreateTripCommand implements ReturningCommand<Long> {

    private String userName;

    @NotNull
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateTime;

    @NotNull
    private String place;

    @NotNull
    private Double coordinateX;

    @NotNull
    private Double coordinateY;

    @NotNull
    private Double radius;


    protected CreateTripCommand() { }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getPlace() {
        return place;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
