package pl.polsl.mushrooms.infrastructure.dao;

import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.DiscoveryDao;
import pl.polsl.mushrooms.application.model.Discovery;
import pl.polsl.mushrooms.infrastructure.repositories.DiscoveryRepository;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
@Repository
public class DiscoveryDaoImpl implements DiscoveryDao {

    private final DiscoveryRepository discoveryRepository;

    public DiscoveryDaoImpl(final DiscoveryRepository discoveryRepository) {

        this.discoveryRepository = discoveryRepository;
    }

    @Override
    public void save(Discovery discovery) {
        discoveryRepository.save(discovery);
    }
}
