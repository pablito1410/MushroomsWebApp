package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.UsersTrips;
import pl.polsl.mushrooms.application.model.UsersTripsId;

import java.util.Set;


@Repository
@RepositoryRestResource(exported = false)
public interface UsersTripsRepository extends JpaRepository<UsersTrips, UsersTripsId> {

    UsersTrips findOne(UsersTripsId usersTripsId);

    Set<UsersTrips> findByUsersTripsId_trip_idAndDateTimeIsNotNull(long tripId);

    Set<UsersTrips> findByUsersTripsId_trip_idAndDateTimeIsNull(long tripId);
}
