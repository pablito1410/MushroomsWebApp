package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;

import java.util.Set;


public interface FriendProjectionService {

    Set<MushroomerDto> findAll(String username);

    Set<MushroomerDto> findRequests(String username);

    Set<MushroomerDto> findInvitations(String username);

    Set<MushroomerDto> search(String userName, String value);
}
