package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.DiscoveryDao;
import pl.polsl.mushrooms.application.model.Discovery;
import pl.polsl.mushrooms.infrastructure.repositories.DiscoveryRepository;

import java.util.Optional;


public class DiscoveryDaoImpl implements DiscoveryDao {

    private final DiscoveryRepository discoveryRepository;

    public DiscoveryDaoImpl(final DiscoveryRepository discoveryRepository) {

        this.discoveryRepository = discoveryRepository;
    }

    @Override
    public void save(Discovery discovery) {
        discoveryRepository.save(discovery);
        discoveryRepository.flush();
    }

    @Override
    public Optional<Discovery> findOne(long discoveryId) {
        return Optional.ofNullable(discoveryRepository.findOne(discoveryId));
    }

    @Override
    public void delete(long id) {
        discoveryRepository.delete(id);
    }

}
