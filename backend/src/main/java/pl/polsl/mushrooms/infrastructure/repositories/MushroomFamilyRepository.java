package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.MushroomFamily;

import java.util.List;



@Repository
@RepositoryRestResource(exported = false)
public interface MushroomFamilyRepository extends JpaRepository<MushroomFamily, Long> {

    List<MushroomFamily> findByNameIgnoreCaseContaining(String value);
}
