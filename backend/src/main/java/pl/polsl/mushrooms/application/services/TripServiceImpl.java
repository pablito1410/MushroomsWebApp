package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.trip.CreateTripCommand;
import pl.polsl.mushrooms.application.commands.trip.DeleteTripCommand;
import pl.polsl.mushrooms.application.commands.trip.UpdateTripCommand;
import pl.polsl.mushrooms.application.dao.TripDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.Trip;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class TripServiceImpl implements TripService {

    private final UserDao userRepo;
    private final TripDao tripRepo;

    public TripServiceImpl(final UserDao userDao, final TripDao tripDao)
    {
        this.userRepo = userDao;
        this.tripRepo = tripDao;
    }

    @Override
    public long handle(CreateTripCommand command) {
        final Trip trip = new Trip(command.getDateTime(), command.getPlace());

        final Mushroomer user = (Mushroomer)userRepo.findOne(command.getUserId());
        trip.addMushroomer(user);

        tripRepo.save(trip);
        return trip.getId();
    }

    @Override
    public void handle(UpdateTripCommand command) {

        final Trip trip = tripRepo.findTrip(command.getTripId());
        final Mushroomer mushroomer = (Mushroomer)userRepo.findOne(command.getUserId());

        trip.addMushroomer(mushroomer);
        tripRepo.save(trip);
    }

    @Override
    public void handle(DeleteTripCommand command) {
        tripRepo.delete(command.getId());
    }
}
