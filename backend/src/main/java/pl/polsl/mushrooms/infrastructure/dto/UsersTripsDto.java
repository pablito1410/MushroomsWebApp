package pl.polsl.mushrooms.infrastructure.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.mushrooms.infrastructure.tools.serializers.LocalDateTimeSerializer;

import java.time.LocalDateTime;


@Getter
@Setter
public class UsersTripsDto {

    protected Long userId;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    protected LocalDateTime dateTime;
}
