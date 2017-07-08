package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;
import pl.polsl.mushrooms.application.enums.NotificationType;

/**
 * Created by chythe on 2017-07-02.
 */
@Getter
@Setter
public class NotificationDto {

    protected long id;
    private String content;
    private NotificationType type;
}
