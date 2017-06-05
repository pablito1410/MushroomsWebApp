package pl.polsl.mushrooms.infrastructure.dao;

import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.DiscoveryProjectionDao;
import pl.polsl.mushrooms.infrastructure.repositories.DiscoveryProjectionRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
@Repository
public class DiscoveryProjectionDaoImpl implements DiscoveryProjectionDao {

    private final DiscoveryProjectionRepository discoveryProjectionRepository;

    public DiscoveryProjectionDaoImpl(DiscoveryProjectionRepository discoveryProjectionRepository) {
        this.discoveryProjectionRepository = discoveryProjectionRepository;
    }

    @Override
    public List<Map<String, Object>> findAll(long userId, Projection projection) {
        return discoveryProjectionRepository.findAll(userId, projection);
    }
}
