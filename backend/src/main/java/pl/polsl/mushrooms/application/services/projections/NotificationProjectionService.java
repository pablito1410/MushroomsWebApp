package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.NotificationDto;

import java.util.Set;


public interface NotificationProjectionService {

    NotificationDto findOne(long notificationId);

    Set<NotificationDto> findAll(String userName);
}
