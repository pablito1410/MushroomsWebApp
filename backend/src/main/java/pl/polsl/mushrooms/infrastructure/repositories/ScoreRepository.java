package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.Score;


@Repository
@RepositoryRestResource(exported = false)
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
