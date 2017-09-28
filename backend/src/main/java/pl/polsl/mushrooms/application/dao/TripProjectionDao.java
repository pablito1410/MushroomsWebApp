package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Trip;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.application.model.UsersTrips;
import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.dto.TripDto;

import java.util.Set;


public interface TripProjectionDao extends ProjectionDao<TripDto> {

    Set<MushroomerDto> findParticipants(long id);

    Set<TripDto> findAll(User user);

    Set<TripDto> findRequests(User user);

    Set<MushroomerDto> findInvited(long tripId);

    UsersTrips findUserTrip(User user, Trip trip);
}