package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.TripDao;
import pl.polsl.mushrooms.application.model.Trip;
import pl.polsl.mushrooms.application.model.UsersTrips;
import pl.polsl.mushrooms.application.model.UsersTripsId;
import pl.polsl.mushrooms.infrastructure.repositories.TripRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UsersTripsRepository;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class TripDaoImpl implements TripDao {


    private final TripRepository repository;
    private final UsersTripsRepository usersTripsRepository;

    public TripDaoImpl(final TripRepository repository, UsersTripsRepository usersTripsRepository)
    {

        this.repository = repository;
        this.usersTripsRepository = usersTripsRepository;
    }

    @Override
    public void save(Trip trip) {
        repository.save(trip);
    }

    @Override
    public Trip findTrip(long tripId) {
        return repository.findOne(tripId);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public UsersTrips findUserTrip(UsersTripsId usersTripsId) {
        return usersTripsRepository.findOne(usersTripsId);
    }

    @Override
    public void save(UsersTrips usersTrips) {
        usersTripsRepository.save(usersTrips);
    }

}
