package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.infrastructure.dto.UserDto;

/**
 * Created by pawel_zaqkxkn on 01.05.2017.
 */
public interface UserProjectionDao extends ProjectionDao<UserDto> {

    UserDto findOneByUsername(String username);

    long getId(String email);

}
