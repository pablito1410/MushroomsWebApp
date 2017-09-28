package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.FriendProjectionDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

import javax.persistence.EntityNotFoundException;
import java.util.Set;


public class FriendProjectionServiceImpl implements FriendProjectionService {

    private final EntityMapper entityMapper;
    private final UserDao userDao;
    private final FriendProjectionDao friendProjectionDao;

    public FriendProjectionServiceImpl(final EntityMapper entityMapper,
                                       final UserDao userDao,
                                       final FriendProjectionDao friendProjectionDao) {
        this.entityMapper = entityMapper;
        this.userDao = userDao;
        this.friendProjectionDao = friendProjectionDao;
    }

    @Override
    public Set<MushroomerDto> findAll(final String username) {
        return friendProjectionDao.findAll(username);
    }

    @Override
    public Set<MushroomerDto> findRequests(final String username) {
        return friendProjectionDao.findRequests(username);
    }

    @Override
    public Set<MushroomerDto> findInvitations(final String username) {
        return friendProjectionDao.findInvitations(username);
    }

    @Override
    public Set<MushroomerDto> search(final String userName, final String value) {
        final User user = userDao.findOneByUsername(userName)
                .orElseThrow(EntityNotFoundException::new);

        return friendProjectionDao.search(user.getId(), value);
    }
}
