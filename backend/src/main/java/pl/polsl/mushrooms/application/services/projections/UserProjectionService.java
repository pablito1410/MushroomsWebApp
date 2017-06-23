package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 30.04.2017.
 */
public interface UserProjectionService {

    UserDto findOne(long id, ProjectionDao.Projection projection);

    UserDto findOneByUsername(String username, ProjectionDao.Projection projection);

    long getId(String email);

    Set<MushroomerDto> findAll(String userName, ProjectionDao.Projection projection);

    Set<MushroomerDto> findAll(long id, ProjectionDao.Projection projection);

    Set<MushroomerDto> search(String value, ProjectionDao.Projection projection);
}
