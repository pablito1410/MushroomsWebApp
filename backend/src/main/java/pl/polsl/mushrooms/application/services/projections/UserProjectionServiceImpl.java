package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;

import java.util.List;
import java.util.Map;

/**
 * Created by pawel_zaqkxkn on 30.04.2017.
 */
public class UserProjectionServiceImpl implements UserProjectionService {


    private final UserProjectionDao userProjectionDao;

    public UserProjectionServiceImpl(UserProjectionDao userProjectionDao) {

        this.userProjectionDao = userProjectionDao;
    }

    @Override
    public Map<String, Object> findOne(long id, UserProjectionDao.Projection projection) {
        return userProjectionDao.findOne(id, projection);
    }

    @Override
    public Map<String, Object> findOneByUsername(String username, UserProjectionDao.Projection projection) {
        return userProjectionDao.findOneByUsername(username, projection);
    }

    @Override
    public long getId(String userName) {
        return userProjectionDao.getId(userName);
    }

    @Override
    public List<Map<String,Object>> findAll(String userName, ProjectionDao.Projection projection) {
        return findAll(getId(userName), projection);
    }

    @Override
    public List<Map<String,Object>> findAll(long id, ProjectionDao.Projection projection) {
        return userProjectionDao.findAll(id, projection);
    }

    @Override
    public List<Map<String, Object>> search(String value, ProjectionDao.Projection projection) {
        return userProjectionDao.search(value, projection);
    }

}
