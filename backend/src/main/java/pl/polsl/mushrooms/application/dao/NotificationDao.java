package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Notification;
import pl.polsl.mushrooms.application.model.Trip;
import pl.polsl.mushrooms.application.model.UsersTrips;
import pl.polsl.mushrooms.application.model.UsersTripsId;

/**
 * Created by chythe on 2017-07-02.
 */
public interface NotificationDao {

    void save(Notification notification);

    Notification findNotification(long notificationId);

    void delete(long notificationId);
}
