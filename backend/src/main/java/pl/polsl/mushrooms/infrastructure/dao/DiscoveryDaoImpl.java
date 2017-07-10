package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.DiscoveryDao;
import pl.polsl.mushrooms.application.model.Discovery;
import pl.polsl.mushrooms.infrastructure.repositories.DiscoveryRepository;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class DiscoveryDaoImpl implements DiscoveryDao {

    private final DiscoveryRepository discoveryRepository;

    public DiscoveryDaoImpl(final DiscoveryRepository discoveryRepository) {

        this.discoveryRepository = discoveryRepository;
    }

    @Override
    public void save(Discovery discovery) {
        discoveryRepository.save(discovery);
    }

    @Override
    public Discovery findDiscovery(long discoveryId) {
        return discoveryRepository.findOne(discoveryId);
    }

    @Override
    public void delete(long id) {
        discoveryRepository.delete(id);
    }
}
