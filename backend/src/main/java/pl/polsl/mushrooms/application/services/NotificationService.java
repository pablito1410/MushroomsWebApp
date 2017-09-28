package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.notification.DeleteNotificationCommand;


public interface NotificationService {

    /**
     * Deletes the notification
     * @param command
     */
    void handle(DeleteNotificationCommand command);
}
