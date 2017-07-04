package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;
import pl.polsl.mushrooms.application.exceptions.NoRequiredPermissions;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 30.04.2017.
 */
public class UserProjectionServiceImpl implements UserProjectionService {


    private final UserProjectionDao userProjectionDao;
    private final UserDao userDao;

    public UserProjectionServiceImpl(
            UserProjectionDao userProjectionDao, UserDao userDao) {

        this.userProjectionDao = userProjectionDao;
        this.userDao = userDao;
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
    public Set<MushroomerDto> findFriends(String username) {
        return findFriends(getId(username));
    }

    @Override
    public Set<MushroomerDto> findFriends(long id) {
        final Set<MushroomerDto> friends = new HashSet<>();
        userProjectionDao.findAll(id).forEach(u -> friends.add((MushroomerDto)u));
        return friends;
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
        final User user = userDao.findOneByUsername(username);
        if (user.isAdmin()) {
            return userProjectionDao.findAll();
        } else {
            throw new NoRequiredPermissions("Admin role is required");
        }
    }

}
