package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.UsersTrips;
import pl.polsl.mushrooms.application.model.UsersTripsId;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */
@Repository
@RepositoryRestResource(exported = false)
public interface UsersTripsRepository extends JpaRepository<UsersTrips, UsersTripsId> {

    UsersTrips findOne(UsersTripsId usersTripsId);
}
