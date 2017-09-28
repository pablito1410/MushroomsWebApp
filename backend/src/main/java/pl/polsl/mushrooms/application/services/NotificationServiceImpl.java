package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.notification.DeleteNotificationCommand;
import pl.polsl.mushrooms.application.dao.NotificationDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.exceptions.NoRequiredPermissions;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.Notification;

import javax.ws.rs.NotFoundException;
import java.util.Optional;


public class NotificationServiceImpl implements NotificationService {

    private final NotificationDao notificationDao;
    private final UserDao userDao;

    public NotificationServiceImpl(NotificationDao notificationDao, UserDao userDao) {
        this.notificationDao = notificationDao;
        this.userDao = userDao;
    }

    @Override
    public void handle(DeleteNotificationCommand command) {
        final Mushroomer currentUser = (Mushroomer)userDao.findOneByUsername(command.getUserName())
                    .orElseThrow(NotFoundException::new);

        final Notification notification = Optional.of(
                notificationDao.findNotification(command.getNotificationId()))
                    .orElseThrow(NotFoundException::new);

        if (!notification.getMushroomer().equals(currentUser)) {
            throw new NoRequiredPermissions("User does not has notification=" + notification.toString());
        }

        notificationDao.delete(command.getNotificationId());
    }
}
