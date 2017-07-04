package pl.polsl.mushrooms.infrastructure.dao;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.DiscoveryProjectionDao;
import pl.polsl.mushrooms.application.model.Discovery;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;
import pl.polsl.mushrooms.infrastructure.repositories.DiscoveryRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.*;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
@Repository
public class DiscoveryProjectionDaoImpl implements DiscoveryProjectionDao {

    private final DiscoveryRepository discoveryRepository;
    private final UserRepository userRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    public DiscoveryProjectionDaoImpl(DiscoveryRepository discoveryRepository, UserRepository userRepository) {
        this.discoveryRepository = discoveryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Set<DiscoveryDto> findAll(long userId) {
        final User user = Optional.ofNullable(
                userRepository.findOne(userId))
                    .orElseThrow(EntityNotFoundException::new);

        if (user instanceof Mushroomer) {
            final Set<Discovery> discoveries = ((Mushroomer) user).getDiscoveries();
            return map(discoveries);
        } else {
            throw new IllegalStateException("User is not instance of Mushroomer");
        }
    }

    @Override
    public Set<DiscoveryDto> findAll() {
        final List<Discovery> discoveries = discoveryRepository.findAll();
        return map(discoveries);
    }

    @Override
    public DiscoveryDto findOne(long id) {
        final Discovery discovery = Optional
                .ofNullable(discoveryRepository.findOne(id))
                    .orElseThrow(EntityNotFoundException::new);
        return map(discovery);
    }

    @Override
    public Set<DiscoveryDto> search(String value) {
        final Set<Discovery> discoveries = discoveryRepository.findByMushroomsSpeciesNameIgnoreCaseContaining(value);
        return map(discoveries);
    }

    private static Set<DiscoveryDto> map(Collection<Discovery> discoveries) {
        return modelMapper.map(discoveries, new TypeToken<Set<DiscoveryDto>>() {}.getType());
    }

    private static DiscoveryDto map(Discovery discovery) {
        return modelMapper.map(discovery, DiscoveryDto.class);
    }
}
