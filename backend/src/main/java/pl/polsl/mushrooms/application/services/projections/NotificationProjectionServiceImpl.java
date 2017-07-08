package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.NotificationProjectionDao;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;
import pl.polsl.mushrooms.infrastructure.dto.NotificationDto;

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
    public NotificationDto findOne(long notificationId) {
        return notificationProjectionDao.findOne(notificationId);
    }

    @Override
    public Set<NotificationDto> findAll(String username) {
        return notificationProjectionDao.findAll(username);
    }
}
