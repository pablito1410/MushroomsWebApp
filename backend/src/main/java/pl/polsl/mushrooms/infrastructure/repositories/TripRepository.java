package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.Trip;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
@Repository
@RepositoryRestResource(exported = false)
public interface TripRepository extends JpaRepository<Trip, Long> {

    Set<Trip> findByPlaceIgnoreCaseContaining(String value);
}
