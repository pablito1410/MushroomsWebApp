package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Trip;

import java.util.List;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public interface TripDao {
    void save(Trip trip);

    Trip findTrip(UUID tripId);

    List<Trip> findAllTrips();
}
