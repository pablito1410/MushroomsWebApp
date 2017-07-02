package pl.polsl.mushrooms.application.commands.notification;

import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.application.enums.NotificationType;

import javax.validation.constraints.NotNull;

/**
 * Created by chythe on 2017-07-02.
 */
public class CreateNotificationCommand implements ReturningCommand<Long> {
    @NotNull
    private String content;
    private NotificationType type;

    protected CreateNotificationCommand() { }

    public String getContent() {
        return content;
    }

    public NotificationType getType() {
        return type;
    }
}
