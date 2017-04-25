package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.trip.CreateCommand;
import pl.polsl.mushrooms.application.commands.trip.DeleteCommand;
import pl.polsl.mushrooms.application.commands.trip.GetCommand;
import pl.polsl.mushrooms.application.commands.trip.UpdateCommand;
import pl.polsl.mushrooms.application.dao.TripDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.Trip;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class TripServiceImpl implements TripService {

    private final UserDao userRepo;
    private final TripDao tripRepo;

    public TripServiceImpl(final UserDao userRepo, final TripDao tripRepo)
    {
        this.userRepo = userRepo;
        this.tripRepo = tripRepo;
    }

    @Override
    public void handle(CreateCommand command) {
        final Trip trip = new Trip(
             command.getDate(), command.getTime(), command.getPlace());

        final Mushroomer user = (Mushroomer)userRepo.findUser(command.getUserId());

        trip.addMushroomer(user);

        tripRepo.save(trip);
    }

    @Override
    public Trip handle(GetCommand command) {
        return null;
    }

    @Override
    public void handle(UpdateCommand command) {

        final Trip trip = tripRepo.findTrip(command.getTripId());
        final Mushroomer mushroomer = (Mushroomer)userRepo.findUser(command.getUserId());

        trip.addMushroomer(mushroomer);
        tripRepo.save(trip);
    }

    @Override
    public void handle(DeleteCommand command) {

    }
}
