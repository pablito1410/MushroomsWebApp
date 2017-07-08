package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.Discovery;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */

@Repository
@RepositoryRestResource(exported = false)
public interface DiscoveryRepository extends JpaRepository<Discovery, Long> {

    Set<Discovery> findByMushroomsSpeciesNameIgnoreCaseContaining(String mushroomsSpeciesName);
}
