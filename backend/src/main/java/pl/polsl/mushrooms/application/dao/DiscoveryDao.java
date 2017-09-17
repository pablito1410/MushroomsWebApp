package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Discovery;

import java.util.Optional;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */

public interface DiscoveryDao {
    void save(Discovery discovery);

    Optional<Discovery> findOne(long discoveryId);

    void delete(long id);

}
