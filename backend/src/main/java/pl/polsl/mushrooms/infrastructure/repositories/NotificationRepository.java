package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.Notification;

/**
 * Created by chythe on 2017-07-02.
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
