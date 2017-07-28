package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.NotificationProjectionDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.NotificationDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

/**
 * Created by chythe on 2017-07-02.
 */
public class NotificationProjectionServiceImpl implements NotificationProjectionService {

    private final NotificationProjectionDao notificationProjectionDao;
    private final UserDao userDao;
    private final EntityMapper entityMapper;

    public NotificationProjectionServiceImpl(NotificationProjectionDao notificationProjectionDao,
                                             UserDao userDao, EntityMapper entityMapper) {
        this.notificationProjectionDao = notificationProjectionDao;
        this.userDao = userDao;
        this.entityMapper = entityMapper;
    }

    @Override
    public NotificationDto findOne(long notificationId) {
        return notificationProjectionDao.findOne(notificationId);
    }

    @Override
    public Set<NotificationDto> findAll(String username) {
        final User user = userDao.findOneByUsername(username)
                .orElseThrow(EntityNotFoundException::new);
        if (user.isAdmin()) {
            return notificationProjectionDao.findAll();
        } else {
            return entityMapper.map(((Mushroomer)user).getNotifications());
        }
    }
}
