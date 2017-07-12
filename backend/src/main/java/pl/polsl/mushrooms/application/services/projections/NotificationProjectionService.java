package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.NotificationDto;

import java.util.Set;

/**
 * Created by chythe on 2017-07-02.
 */
public interface NotificationProjectionService {

    NotificationDto findOne(long notificationId);

    Set<NotificationDto> findAll(String userName);
}
