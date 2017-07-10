package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.trip.*;
import pl.polsl.mushrooms.application.dao.TripDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.enums.NotificationType;
import pl.polsl.mushrooms.application.exceptions.EntityAlreadyExistException;
import pl.polsl.mushrooms.application.exceptions.NoRequiredPermissions;
import pl.polsl.mushrooms.application.model.*;

import javax.ws.rs.NotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;

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
        final String currentUsername = command.getUserName();
        final Mushroomer user = (Mushroomer)userRepo.findOneByUsername(currentUsername);

        final Trip trip = new Trip(
                command.getDateTime(),
                command.getPlace(),
                command.getCoordinateX(),
                command.getCoordinateY(),
                command.getRadius());

        trip.addMushroomer(user);
        tripRepo.save(trip);

        return trip.getId();
    }

    @Override
    public void handle(UpdateTripCommand command) {
        final Trip trip = Optional.of(
                tripRepo.findTrip(command.getTripId()))
                    .orElseThrow(NotFoundException::new);

        trip.setPlace(command.getPlace());
        trip.setDateTime(command.getDateTime());
        tripRepo.save(trip);
    }

    @Override
    public void handle(DeleteTripCommand command) {
        final String currentUsername = command.getUserName();
        final Mushroomer currentUser = (Mushroomer)Optional.ofNullable(
                userRepo.findOneByUsername(currentUsername))
                    .orElseThrow(NotFoundException::new);

        final Trip trip = Optional.of(
                tripRepo.findTrip(command.getTripId()))
                    .orElseThrow(NotFoundException::new);

        if (!trip.getMushroomers().contains(currentUser)) {
            throw new NoRequiredPermissions("User should be a participant of the trip.");
        }

        tripRepo.delete(command.getTripId());
    }

    @Override
    public void handle(JoinTripCommand command) {
        final String currentUsername = command.getUserName();
        final Mushroomer mushroomer = (Mushroomer)Optional.ofNullable(
                userRepo.findOneByUsername(currentUsername))
                .orElseThrow(NotFoundException::new);

        final Trip trip = Optional.ofNullable(
                tripRepo.findTrip(command.getTripId()))
                .orElseThrow(NotFoundException::new);

        final UsersTripsId usersTripsId = new UsersTripsId(mushroomer, trip);

        final UsersTrips usersTrips = Optional.ofNullable(
                tripRepo.findUserTrip(usersTripsId))
                .orElseThrow(NotFoundException::new);

        if (usersTrips.getDateTime() == null) {
            usersTrips.setDateTime(LocalDateTime.now());
            tripRepo.save(usersTrips);
        } else {
            throw new EntityAlreadyExistException("User already join to the trip");
        }
    }

    @Override
    public void handle(InviteToTripCommand command) {

        final Trip trip = Optional.ofNullable(
                tripRepo.findTrip(command.getTripId()))
                .orElseThrow(NotFoundException::new);

        for (Long userId : command.getUserIds()) {
            final Mushroomer mushroomer = (Mushroomer)userRepo.findOne(userId);

            if (mushroomer != null) {
                trip.addMushroomer(mushroomer);

                final User userOfContent = userRepo.findOneByUsername(command.getCurrentUsername());
                mushroomer.addNotification(trip.getId(), NotificationType.TRIP_ADDING, userOfContent);
            }
        }

        tripRepo.save(trip);
    }

}
