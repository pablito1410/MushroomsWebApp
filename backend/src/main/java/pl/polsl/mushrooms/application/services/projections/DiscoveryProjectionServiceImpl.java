package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.DiscoveryProjectionDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.CommentDto;
import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public class DiscoveryProjectionServiceImpl implements DiscoveryProjectionService {

    private final DiscoveryProjectionDao discoveryProjectionDao;
    private final UserDao userDao;
    private final EntityMapper entityMapper;

    public DiscoveryProjectionServiceImpl(
            final DiscoveryProjectionDao discoveryProjectionDao,
            final UserDao userDao, EntityMapper entityMapper) {
        this.discoveryProjectionDao = discoveryProjectionDao;
        this.userDao = userDao;
        this.entityMapper = entityMapper;
    }

    @Override
    public DiscoveryDto findOne(long id) {
        return discoveryProjectionDao.findOne(id);
    }

    @Override
    public Set<DiscoveryDto> findAll(String username) {
        final User user = userDao.findOneByUsername(username)
                .orElseThrow(EntityNotFoundException::new);
        if (user.isAdmin()) {
            return discoveryProjectionDao.findAll();
        } else {
            return entityMapper.map(((Mushroomer)user).getDiscoveries());
        }
    }

    @Override
    public Set<DiscoveryDto> search(final String userName, final String value, final boolean my, final boolean friends, final boolean isPublic) {
        return discoveryProjectionDao.search(userName, value, my, friends, isPublic);
    }

    @Override
    public Set<TagDto> findTags(final long id) {
        return discoveryProjectionDao.findTags(id);
    }

    @Override
    public Set<CommentDto> findComments(final long id) {
        return discoveryProjectionDao.findComments(id);
    }

}
