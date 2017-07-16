package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.MushroomClass;

import java.util.List;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */

@Repository
@RepositoryRestResource(exported = false)
public interface MushroomClassRepository extends JpaRepository<MushroomClass, Long> {

    List<MushroomClass> findByNameIgnoreCaseContaining(String value);
}
