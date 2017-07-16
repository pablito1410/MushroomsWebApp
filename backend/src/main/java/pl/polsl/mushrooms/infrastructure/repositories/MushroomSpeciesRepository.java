package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.MushroomSpecies;

import java.util.List;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 27.06.2017.
 */
@Repository
@RepositoryRestResource(exported = false)
public interface MushroomSpeciesRepository extends JpaRepository<MushroomSpecies, Long> {

    Set<MushroomSpecies> findAllByDiscoveries_Mushroomer_Id(long id);

    List<MushroomSpecies> findByNameIgnoreCaseContaining(String value);
}
