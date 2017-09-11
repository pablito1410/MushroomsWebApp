package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.TagProjectionDao;
import pl.polsl.mushrooms.application.model.Discovery;
import pl.polsl.mushrooms.application.model.Tag;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.DiscoveryRepository;
import pl.polsl.mushrooms.infrastructure.repositories.TagRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 28.07.2017.
 */
public class TagProjectionDaoImpl implements TagProjectionDao {

    private final TagRepository tagRepository;
    private final UserRepository userRepository;
    private final DiscoveryRepository discoveryRepository;
    private final EntityMapper entityMapper;


    public TagProjectionDaoImpl(
            final TagRepository tagRepository,
            final UserRepository userRepository,
            final DiscoveryRepository discoveryRepository,
            final EntityMapper entityMapper) {

        this.tagRepository = tagRepository;
        this.userRepository = userRepository;
        this.discoveryRepository = discoveryRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Set<TagDto> findAll(long userId) {
        final Set<Tag> tags = tagRepository.findByDiscoveryMushroomerId(userId);// TODO
        return entityMapper.map(tags);
    }

    @Override
    public Set<TagDto> findAll() {
        final List<Tag> tags = tagRepository.findAll();
        return entityMapper.map(tags);
    }

    @Override
    public TagDto findOne(long id) {
        final Tag tag = tagRepository.findOne(id);
        return entityMapper.map(tag);
    }

    @Override
    public Set<TagDto> search(String value) {
        final Set<Tag> tags = tagRepository.findByNameIgnoreCaseContaining(value);
        return entityMapper.map(tags);
    }

    @Override
    public Set<TagDto> findByDiscoveryId(long discoveryId) {
        final Discovery discovery = Optional.ofNullable(
                discoveryRepository.findOne(discoveryId))
                    .orElseThrow(EntityNotFoundException::new);
        final Set<Tag> tags = discovery.getTags();
        return entityMapper.map(tags);
    }
}
