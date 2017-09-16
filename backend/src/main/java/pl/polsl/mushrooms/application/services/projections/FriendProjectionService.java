package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.09.2017.
 */
public interface FriendProjectionService {

    Set<MushroomerDto> findAll(String username);

    Set<MushroomerDto> findRequests(String username);

    Set<MushroomerDto> findInvitations(String username);
}
