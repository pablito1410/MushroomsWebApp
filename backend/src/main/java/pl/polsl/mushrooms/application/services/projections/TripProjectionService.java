package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.TripDto;
import pl.polsl.mushrooms.infrastructure.dto.UsersTripsDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public interface TripProjectionService {

    TripDto findOne(long id);

    Set<TripDto> findAll(String userName);

    Set<TripDto> search(String value);

    Set<UsersTripsDto> findParticipants(long id);

    Set<TripDto> findRequests(String username);

    Set<UsersTripsDto> findInvited(long id);
}
