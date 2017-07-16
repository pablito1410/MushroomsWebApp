package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.Notification;

/**
 * Created by chythe on 2017-07-02.
 */
@Repository
@RepositoryRestResource(exported = false)
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
