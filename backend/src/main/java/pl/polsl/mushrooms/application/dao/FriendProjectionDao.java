package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 04.07.2017.
 */
public interface FriendProjectionDao extends ProjectionDao<MushroomerDto> {

    Set<MushroomerDto> findAll(String username);

    Set<MushroomerDto> findRequests(String username);

    Set<MushroomerDto> findInvitations(String username);

    Set<MushroomerDto> search(Long userId, String value);
}
