package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Trip;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public interface TripDao {

    void save(Trip trip);

    Trip findTrip(long tripId);

    void delete(long tripId);
}
