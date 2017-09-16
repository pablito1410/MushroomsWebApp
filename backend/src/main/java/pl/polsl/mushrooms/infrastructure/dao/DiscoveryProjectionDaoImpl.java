package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.DiscoveryProjectionDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Comment;
import pl.polsl.mushrooms.application.model.Discovery;
import pl.polsl.mushrooms.application.model.Tag;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.CommentDto;
import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.DiscoveryRepository;

import javax.persistence.EntityNotFoundException;
import java.util.*;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public class DiscoveryProjectionDaoImpl implements DiscoveryProjectionDao {

    private final DiscoveryRepository discoveryRepository;
    private final UserDao userDao;
    private final EntityMapper entityMapper;

    public DiscoveryProjectionDaoImpl(
            final DiscoveryRepository discoveryRepository,
            final UserDao userDao,
            final EntityMapper entityMapper) {
        this.discoveryRepository = discoveryRepository;
        this.userDao = userDao;
        this.entityMapper = entityMapper;
    }

//    @Override
//    public Set<DiscoveryDto> findAll(long userId) {
//        final User user = Optional.ofNullable(
//                userDao.findOne(userId))
//                    .orElseThrow(EntityNotFoundException::new);
//
//        if (user instanceof Mushroomer) {
//            final Set<Discovery> discoveries = ((Mushroomer) user).getDiscoveries();
//            return entityMapper.map(discoveries);
//        } else {
//            throw new IllegalStateException("User is not instance of Mushroomer");
//        }
//    }

    @Override
    public Set<DiscoveryDto> findAll() {
        final List<Discovery> discoveries = discoveryRepository.findAll();
        return entityMapper.map(discoveries);
    }

    @Override
    public DiscoveryDto findOne(long id) {
        final Discovery discovery = Optional
                .ofNullable(discoveryRepository.findOne(id))
                    .orElseThrow(EntityNotFoundException::new);
        return entityMapper.map(discovery);
    }

    @Override
    public Set<DiscoveryDto> search(String value) {
        final Set<Discovery> discoveries = discoveryRepository.findByMushroomsSpeciesNameIgnoreCaseContaining(value);
        return entityMapper.map(discoveries);
    }

    @Override
    public Set<DiscoveryDto> search(final String userName,
                                    final String value,
                                    final boolean my,
                                    final boolean friends,
                                    final boolean isPublic) {
        final User user = userDao.findOneByUsername(userName)
                .orElseThrow(EntityNotFoundException::new);

        final Set<Discovery> results = new HashSet<>();

        if (my) {
            results.addAll(searchByUser(user, value));
        }

        if (friends) {
            results.addAll(searchByFriends(user, value));
        }

        if (isPublic) {
            results.addAll(searchPublic(value));
        }

        return entityMapper.map(results);
    }

    @Override
    public Set<TagDto> findTags(long discoveryId) {
        final Discovery discovery = Optional.ofNullable(
                discoveryRepository.findOne(discoveryId))
                .orElseThrow(EntityNotFoundException::new);
        final Set<Tag> tags = discovery.getTags();
        return entityMapper.map(tags);
    }

    @Override
    public Set<CommentDto> findComments(final long discoveryId) {
        final Discovery discovery = Optional.ofNullable(
                discoveryRepository.findOne(discoveryId))
                .orElseThrow(EntityNotFoundException::new);
        final Set<Comment> comments = discovery.getComments();
        return entityMapper.map(comments);
    }

    private Collection<? extends Discovery> searchPublic(final String value) {
        return discoveryRepository.findByIsPublicAndMushroomsSpeciesNameIgnoreCaseContaining(true, value);
    }

    private Collection<? extends Discovery> searchByFriends(final User user, final String value) {
        return discoveryRepository.findByFriends(user.getId(), value);
    }

    private Collection<? extends Discovery> searchByUser(final User user, final String value) {
        return discoveryRepository.findByMushroomerIdAndMushroomsSpeciesNameIgnoreCaseContaining(user.getId(), value);
    }
}
