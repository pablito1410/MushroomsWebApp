package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.UserProjectionDao;

import java.util.Map;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 30.04.2017.
 */
public interface UserProjectionService {

    Map<String, Object> findOne(UUID id, UserProjectionDao.Projection projection);
}
