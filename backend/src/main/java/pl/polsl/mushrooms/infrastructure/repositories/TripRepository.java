package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.Trip;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
@Repository
public interface TripRepository extends JpaRepository<Trip, UUID> {
}
