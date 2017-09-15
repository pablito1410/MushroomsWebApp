package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.TagProjectionDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 17.07.2017.
 */
public class TagProjecitonServiceImpl implements TagProjectionService {

    private final TagProjectionDao tagProjectionDao;
    private final UserDao userDao;

    public TagProjecitonServiceImpl(
            final TagProjectionDao tagProjectionDao,
            final UserDao userDao) {
        this.tagProjectionDao = tagProjectionDao;
        this.userDao = userDao;
    }

    @Override
    public Set<TagDto> findAll(String userName) {
        final User user = userDao.findOneByUsername(userName)
                .orElseThrow(EntityNotFoundException::new);
        if (user.isAdmin()) {
            return tagProjectionDao.findAll();
        } else {
            return tagProjectionDao.findAll(user.getId());
        }
    }

    @Override
    public TagDto findOne(long id) {
        return tagProjectionDao.findOne(id);
    }

    @Override
    public Set<TagDto> search(String value) {
        return tagProjectionDao.search(value);
    }

    @Override
    public Set<TagDto> findByDiscoveryId(long discoveryId) {
        return tagProjectionDao.findByDiscoveryId(discoveryId);
    }

}