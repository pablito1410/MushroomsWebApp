package pl.polsl.mushrooms.infrastructure.dao;

import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.NotificationDao;
import pl.polsl.mushrooms.application.model.Notification;
import pl.polsl.mushrooms.infrastructure.repositories.NotificationRepository;
import pl.polsl.mushrooms.infrastructure.repositories.ScoreRepository;

/**
 * Created by chythe on 2017-07-02.
 */
@Repository
public class NotificationDaoImpl implements NotificationDao {

    private final NotificationRepository notificationRepository;

    public NotificationDaoImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void save(Notification notification) {
        notificationRepository.save(notification);
    }

    @Override
    public Notification findNotification(long notificationId) {
        return notificationRepository.findOne(notificationId);
    }

    @Override
    public void delete(long notificationId) {
        notificationRepository.delete(notificationId);
    }
}
