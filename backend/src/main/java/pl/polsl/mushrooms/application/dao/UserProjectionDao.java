package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;


public interface UserProjectionDao extends ProjectionDao<MushroomerDto> {

    UserDto findOneByUsername(String username);

    long getId(String email);

}
