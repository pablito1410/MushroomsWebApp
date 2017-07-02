package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.notification.CreateNotificationCommand;
import pl.polsl.mushrooms.application.commands.notification.DeleteNotificationCommand;
import pl.polsl.mushrooms.application.commands.notification.UpdateNotificationCommand;

/**
 * Created by chythe on 2017-07-02.
 */
public interface NotificationService {

    long handle(CreateNotificationCommand command);

    void handle(UpdateNotificationCommand command);

    void handle(DeleteNotificationCommand command);
}
