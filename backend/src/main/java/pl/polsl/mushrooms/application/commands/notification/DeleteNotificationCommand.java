package pl.polsl.mushrooms.application.commands.notification;

import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by chythe on 2017-07-02.
 */
public class DeleteNotificationCommand implements VoidCommand {
    @NotNull
    private long id;

    protected DeleteNotificationCommand() { }

    public DeleteNotificationCommand(long notificationId) {
        this.id = notificationId;
    }

    public long getNotificationId() {
        return id;
    }
}
