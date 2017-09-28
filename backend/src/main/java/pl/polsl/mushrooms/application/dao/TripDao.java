package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Trip;
import pl.polsl.mushrooms.application.model.UsersTrips;
import pl.polsl.mushrooms.application.model.UsersTripsId;


public interface TripDao {

    void save(Trip trip);

    Trip findTrip(long tripId);

    void delete(long tripId);

    UsersTrips findUserTrip(UsersTripsId usersTripsId);

    void save(UsersTrips usersTrips);
}
