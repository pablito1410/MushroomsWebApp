package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.MushroomGenus;

import java.util.List;



@Repository
@RepositoryRestResource(exported = false)
public interface MushroomGenusRepository extends JpaRepository<MushroomGenus, Long> {

    List<MushroomGenus> findByNameIgnoreCaseContaining(String value);
}
