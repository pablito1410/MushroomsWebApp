package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.Trip;

import java.util.List;
import java.util.Set;


@Repository
@RepositoryRestResource(exported = false)
public interface TripRepository extends JpaRepository<Trip, Long> {

    Set<Trip> findByPlaceIgnoreCaseContaining(String value);

    @Query("SELECT t FROM User u, UsersTrips ut " +
            "JOIN u.trips t " +
            "WHERE ut.usersTripsId.trip.id = t.id" +
            " AND ut.usersTripsId.user.id = u.id" +
            " AND ut.dateTime IS NOT NULL" +
            " AND u.id = :userId")
    List<Trip> findAllAndAccepted(@Param("userId") long userId);

    @Query("SELECT t FROM User u, UsersTrips ut " +
            "JOIN u.trips t " +
            "WHERE ut.usersTripsId.trip.id = t.id" +
            " AND ut.usersTripsId.user.id = u.id " +
            " AND ut.dateTime IS NULL" +
            " AND u.id = :userId")
    List<Trip> findRequests(@Param("userId") long userId);

}
