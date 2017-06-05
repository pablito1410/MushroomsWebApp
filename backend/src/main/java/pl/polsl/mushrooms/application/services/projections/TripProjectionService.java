package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.ProjectionDao;

import java.util.List;
import java.util.Map;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public interface TripProjectionService {

    Map<String,Object> findOne(long id, ProjectionDao.Projection projection);

    List<Map<String, Object>> findAll(String userName, ProjectionDao.Projection projection);

    List<Map<String, Object>> findAll(long userId, ProjectionDao.Projection projection);
}
