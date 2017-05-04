package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.UserProjectionDao;

import java.util.Map;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 30.04.2017.
 */
public class UserProjectionServiceImpl implements UserProjectionService {


    private final UserProjectionDao userProjectionDao;

    public UserProjectionServiceImpl(UserProjectionDao userProjectionDao) {

        this.userProjectionDao = userProjectionDao;
    }

    @Override
    public Map<String, Object> findOne(UUID id, UserProjectionDao.Projection projection) {
        return userProjectionDao.findOne(id, projection);
    }
}
