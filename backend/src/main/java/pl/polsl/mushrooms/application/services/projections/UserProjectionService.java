package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 30.04.2017.
 */
public interface UserProjectionService {

    UserDto findOne(long id);

    UserDto findOneByUsername(String username);

    long getId(String email);

    Set<MushroomerDto> search(String userName, String value);

    Set<MushroomerDto> findAll(String username);

}
