package pl.polsl.mushrooms.infrastructure.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.mushrooms.infrastructure.controllers.LocalDateTimeSerializer;

import java.time.LocalDateTime;

/**
 * Created by pawel_zaqkxkn on 21.06.2017.
 */
@Getter
@Setter
public class TripDto {

    private long id;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTime;

    private String place;

    private Double coordinateX;
    private Double coordinateY;
    private Double radius;
}
