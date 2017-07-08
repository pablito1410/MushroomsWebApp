package pl.polsl.mushrooms.application.services;

import org.springframework.security.core.context.SecurityContextHolder;
import pl.polsl.mushrooms.application.commands.notification.CreateNotificationCommand;
import pl.polsl.mushrooms.application.commands.notification.DeleteNotificationCommand;
import pl.polsl.mushrooms.application.commands.notification.UpdateNotificationCommand;
import pl.polsl.mushrooms.application.dao.DiscoveryDao;
import pl.polsl.mushrooms.application.dao.NotificationDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.exceptions.NoRequiredPermissions;
import pl.polsl.mushrooms.application.model.*;

import javax.ws.rs.NotFoundException;
import java.util.Optional;

/**
 * Created by chythe on 2017-07-02.
 */
public class NotificationServiceImpl implements NotificationService {

    private final NotificationDao notificationDao;
    private final UserDao userDao;

    public NotificationServiceImpl(NotificationDao notificationDao, UserDao userDao) {
        this.notificationDao = notificationDao;
        this.userDao = userDao;
    }

    @Override
    public long handle(CreateNotificationCommand command) {
        final String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        final Mushroomer currentUser = (Mushroomer) Optional.ofNullable(
                userDao.findOneByUsername(currentUsername))
                .orElseThrow(NotFoundException::new);

        final Notification notification = new Notification(
                command.getContent(),
                command.getType(),
                currentUser
        );
        notificationDao.save(notification);
        return currentUser.getId();
    }

    @Override
    public void handle(UpdateNotificationCommand command) {
        final String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        final Mushroomer currentUser = (Mushroomer) Optional.ofNullable(
                userDao.findOneByUsername(currentUsername))
                    .orElseThrow(NotFoundException::new);
        final Notification notification = Optional.of(
                notificationDao.findNotification(command.getId()))
                    .orElseThrow(NotFoundException::new);
        notification.setContent(command.getContent());
        notification.setType(command.getType());
        notificationDao.save(notification);
    }

    @Override
    public void handle(DeleteNotificationCommand command) {
        final String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        final Mushroomer currentUser = (Mushroomer) Optional.ofNullable(
                userDao.findOneByUsername(currentUsername))
                .orElseThrow(NotFoundException::new);

        final Notification notification = Optional.of(
                notificationDao.findNotification(command.getNotificationId()))
                .orElseThrow(NotFoundException::new);

        if (!notification.getMushroomer().equals(currentUser)) {
            throw new NoRequiredPermissions("User should be a participant of the notification.");
        }

        notificationDao.delete(command.getNotificationId());
    }
}
