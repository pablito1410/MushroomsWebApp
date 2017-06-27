package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.mushrooms.application.model.MushroomSpecies;

/**
 * Created by pawel_zaqkxkn on 27.06.2017.
 */
public interface MushSpeciesRepository extends JpaRepository<MushroomSpecies, Long> {
}
