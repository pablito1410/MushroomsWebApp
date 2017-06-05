package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.ProjectionDao;

import java.util.List;
import java.util.Map;

/**
 * Created by pawel_zaqkxkn on 30.04.2017.
 */
public interface UserProjectionService {

    Map<String, Object> findOne(long id, ProjectionDao.Projection projection);

    Map<String, Object> findOneByUsername(String username, ProjectionDao.Projection projection);

    long getId(String email);

    List<Map<String, Object>> findAll(String userName, ProjectionDao.Projection projection);

    List<Map<String, Object>> findAll(long id, ProjectionDao.Projection projection);

    List<Map<String, Object>> search(String value, ProjectionDao.Projection projection);
}
