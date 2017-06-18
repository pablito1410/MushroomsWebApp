package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Discovery;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */

public interface DiscoveryDao {
    void save(Discovery discovery);

    Discovery findDiscovery(long discoveryId);

    void delete(long id);
}
