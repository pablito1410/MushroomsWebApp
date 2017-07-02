package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.infrastructure.dto.NotificationDto;
import pl.polsl.mushrooms.infrastructure.dto.TripDto;

import java.util.Map;
import java.util.Set;

/**
 * Created by chythe on 2017-07-02.
 */
public interface NotificationProjectionService {
    NotificationDto findOne(long notificationId, ProjectionDao.Projection projection);
    Set<NotificationDto> findAll(String userName, ProjectionDao.Projection projection);
}
