package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;
import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;

import java.util.Collections;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 30.04.2017.
 */
public class UserProjectionServiceImpl implements UserProjectionService {


    private final UserProjectionDao userProjectionDao;

    public UserProjectionServiceImpl(UserProjectionDao userProjectionDao) {

        this.userProjectionDao = userProjectionDao;
    }

    @Override
    public UserDto findOne(long id, UserProjectionDao.Projection projection) {
        return userProjectionDao.findOne(id, projection);
    }

    @Override
    public UserDto findOneByUsername(String username, UserProjectionDao.Projection projection) {
        return userProjectionDao.findOneByUsername(username, projection);
    }

    @Override
    public long getId(String userName) {
        return userProjectionDao.getId(userName);
    }

    @Override
    public Set<MushroomerDto> findAll(String userName, ProjectionDao.Projection projection) {
        return findAll(getId(userName), projection);
    }

    @Override
    public Set<MushroomerDto> findAll(long id, ProjectionDao.Projection projection) {
        return userProjectionDao.findAll(id, projection);
    }

    @Override
    public Set<MushroomerDto> search(String value, ProjectionDao.Projection projection) {
        if (value == null || value.isEmpty()) {
            return Collections.emptySet();
        }
        return userProjectionDao.search(value, projection);
    }

}
