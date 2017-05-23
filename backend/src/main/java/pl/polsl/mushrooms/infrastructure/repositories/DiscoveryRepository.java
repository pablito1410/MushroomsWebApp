package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.Discovery;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */

@Repository
public interface DiscoveryRepository extends JpaRepository<Discovery, Long> {
}
