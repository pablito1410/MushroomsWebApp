package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.ProjectionDao;

import java.util.Map;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 30.04.2017.
 */
public interface UserProjectionService {

    Map<String, Object> findOne(UUID id, ProjectionDao.Projection projection);

    Map<String, Object> findOneByUsername(String username, ProjectionDao.Projection projection);

    UUID getId(String email);

    Map<String,Object> findAll(String currentUserEmail, ProjectionDao.Projection projection);

    Map<String,Object> findAll(UUID id, ProjectionDao.Projection projection);
}
