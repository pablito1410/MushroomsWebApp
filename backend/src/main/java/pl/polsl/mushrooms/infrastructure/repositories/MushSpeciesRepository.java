package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.MushroomSpecies;

/**
 * Created by pawel_zaqkxkn on 27.06.2017.
 */
@Repository
public interface MushSpeciesRepository extends JpaRepository<MushroomSpecies, Long> {
}
