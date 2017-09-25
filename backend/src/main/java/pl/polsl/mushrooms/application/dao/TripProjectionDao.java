package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.TripDto;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public interface TripProjectionDao extends ProjectionDao<TripDto> {

    Set<UserDto> findParticipants(long id);

    Set<TripDto> findAll(User user);

    Set<TripDto> findRequests(User user);

    Set<UserDto> findInvited(long tripId);
}