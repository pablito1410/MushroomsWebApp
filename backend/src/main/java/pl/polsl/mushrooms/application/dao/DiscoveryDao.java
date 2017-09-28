package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Discovery;
import java.util.Optional;

public interface DiscoveryDao {
    void save(Discovery discovery);

    Optional<Discovery> findOne(long discoveryId);

    void delete(long id);

}
