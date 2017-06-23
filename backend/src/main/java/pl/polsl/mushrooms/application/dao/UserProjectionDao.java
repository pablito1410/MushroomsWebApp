package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 01.05.2017.
 */
public interface UserProjectionDao extends ProjectionDao {

    UserDto findOneByUsername(String username, Projection projection);

    UserDto findOne(long id, Projection projection);

    long getId(String email);

    Set<MushroomerDto> findAll(long id, Projection projection);

    Set<MushroomerDto> search(String value, Projection projection);
}
