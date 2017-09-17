package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.FriendProjectionDao;
import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.09.2017.
 */
public class FriendProjectionServiceImpl implements FriendProjectionService {

    private final EntityMapper entityMapper;
    private final FriendProjectionDao friendProjectionDao;

    public FriendProjectionServiceImpl(final EntityMapper entityMapper, final FriendProjectionDao friendProjectionDao) {
        this.entityMapper = entityMapper;
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
}
