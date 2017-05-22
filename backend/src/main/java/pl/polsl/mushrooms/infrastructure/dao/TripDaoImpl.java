package pl.polsl.mushrooms.infrastructure.dao;

import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.TripDao;
import pl.polsl.mushrooms.application.model.Trip;
import pl.polsl.mushrooms.infrastructure.repositories.TripRepository;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
@Repository
public class TripDaoImpl implements TripDao {


    private final TripRepository repository;

    public TripDaoImpl(final TripRepository repository)
    {

        this.repository = repository;
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

}
