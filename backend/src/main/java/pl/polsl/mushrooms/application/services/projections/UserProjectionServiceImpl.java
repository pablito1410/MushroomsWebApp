package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 30.04.2017.
 */
public class UserProjectionServiceImpl implements UserProjectionService {


    private final UserProjectionDao userProjectionDao;
    private final UserDao userDao;
    private final EntityMapper entityMapper;

    public UserProjectionServiceImpl(
            UserProjectionDao userProjectionDao, UserDao userDao, EntityMapper entityMapper) {

        this.userProjectionDao = userProjectionDao;
        this.userDao = userDao;
        this.entityMapper = entityMapper;
    }

    @Override
    public UserDto findOne(long id) {
        return userProjectionDao.findOne(id);
    }

    @Override
    public UserDto findOneByUsername(String username) {
        return userProjectionDao.findOneByUsername(username);
    }

    @Override
    public long getId(String username) {
        return userProjectionDao.getId(username);
    }

    @Override
    public Set<UserDto> search(String value) {
        if (value == null || value.isEmpty()) {
            return Collections.emptySet();
        }
        return userProjectionDao.search(value);
    }

    @Override
    public Set<UserDto> findAll(String username) {
        final User user = userDao.findOneByUsername(username)
                .orElseThrow(EntityNotFoundException::new);
        if (user.isAdmin()) {
            return userProjectionDao.findAll();
        } else {
            return entityMapper.map(((Mushroomer)user).getFriends());
        }
    }

}
