package pl.polsl.mushrooms.infrastructure.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.mushrooms.infrastructure.controllers.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

/**
 * Created by pawel_zaqkxkn on 21.06.2017.
 */
@Getter
@Setter
public class TripDto {

    private long id;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateTime;

    private String place;
}
