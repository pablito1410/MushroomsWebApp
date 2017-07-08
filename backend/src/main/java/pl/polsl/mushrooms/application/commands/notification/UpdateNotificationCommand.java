package pl.polsl.mushrooms.application.commands.notification;

import pl.polsl.mushrooms.application.commands.VoidCommand;
import pl.polsl.mushrooms.application.enums.NotificationType;

import javax.validation.constraints.NotNull;

/**
 * Created by chythe on 2017-07-02.
 */
public class UpdateNotificationCommand implements VoidCommand {
    @NotNull
    private long id;
    private String content;
    private NotificationType type;

    protected UpdateNotificationCommand() { }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public NotificationType getType() {
        return type;
    }
}
