package pl.polsl.mushrooms.infrastructure.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.mushrooms.application.enums.NotificationType;
import pl.polsl.mushrooms.infrastructure.tools.serializers.LocalDateTimeSerializer;

import java.time.LocalDateTime;

/**
 * Created by chythe on 2017-07-02.
 */
@Getter
@Setter
public class NotificationDto {

    private long id;
    private String content;
    private NotificationType type;
    private long relatedId;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTime;
}
