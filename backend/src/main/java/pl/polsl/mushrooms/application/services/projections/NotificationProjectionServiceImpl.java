package pl.polsl.mushrooms.application.services.projections;

import org.springframework.security.core.context.SecurityContextHolder;
import pl.polsl.mushrooms.application.dao.NotificationProjectionDao;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.infrastructure.dto.NotificationDto;

import javax.ws.rs.NotFoundException;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Created by chythe on 2017-07-02.
 */
public class NotificationProjectionServiceImpl implements NotificationProjectionService {

    private final NotificationProjectionDao notificationProjectionDao;
    private final UserProjectionDao userProjectionDao;

    public NotificationProjectionServiceImpl(NotificationProjectionDao notificationProjectionDao,
                                             UserProjectionDao userProjectionDao) {
        this.notificationProjectionDao = notificationProjectionDao;
        this.userProjectionDao = userProjectionDao;
    }

    @Override
    public NotificationDto findOne(long notificationId, ProjectionDao.Projection projection) {
        return notificationProjectionDao.findOne(notificationId, projection);
    }

    @Override
    public Set<NotificationDto> findAll(String userName, ProjectionDao.Projection projection) {
        return notificationProjectionDao.findAll(userName, projection);
    }
}
