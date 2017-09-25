package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.dto.TripDto;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public interface TripProjectionService {

    TripDto findOne(long id);

    Set<TripDto> findAll(String userName);

    Set<TripDto> search(String value);

    Set<MushroomerDto> findParticipants(long id);

    Set<TripDto> findRequests(String username);

    Set<MushroomerDto> findInvited(long id);

    LocalDateTime acceptDateTime(String username, final long tripId);
}
