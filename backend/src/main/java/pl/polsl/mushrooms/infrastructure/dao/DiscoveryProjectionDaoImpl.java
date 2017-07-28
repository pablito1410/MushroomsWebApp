package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.DiscoveryProjectionDao;
import pl.polsl.mushrooms.application.model.Discovery;
import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.DiscoveryRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public class DiscoveryProjectionDaoImpl implements DiscoveryProjectionDao {

    private final DiscoveryRepository discoveryRepository;
    private final UserRepository userRepository;
    private final EntityMapper entityMapper;

    public DiscoveryProjectionDaoImpl(
            final DiscoveryRepository discoveryRepository,
            final UserRepository userRepository,
            final EntityMapper entityMapper) {
        this.discoveryRepository = discoveryRepository;
        this.userRepository = userRepository;
        this.entityMapper = entityMapper;
    }

//    @Override
//    public Set<DiscoveryDto> findAll(long userId) {
//        final User user = Optional.ofNullable(
//                userRepository.findOne(userId))
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

}
