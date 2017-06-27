package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by pawel_zaqkxkn on 21.06.2017.
 */
@Getter
@Setter
public class TripDto {

    private long id;
    private LocalDateTime dateTime;
    private String place;
}
