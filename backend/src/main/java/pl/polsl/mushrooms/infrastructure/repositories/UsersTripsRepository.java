package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.mushrooms.application.model.UsersTrips;
import pl.polsl.mushrooms.application.model.UsersTripsId;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */
public interface UsersTripsRepository extends JpaRepository<UsersTrips, UsersTripsId> {

    UsersTrips findOne(UsersTripsId usersTripsId);
}
