package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.ProjectionDao;

import java.util.Map;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public interface CommentProjectionService {
    Map<String,Object> findOne(long id, ProjectionDao.Projection projection);
}
