package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.ProjectionDao;

import java.util.Map;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public class DiscoveryProjectionServiceImpl implements DiscoveryProjectionService {
    @Override
    public Map<String, Object> findOne(UUID id, ProjectionDao.Projection projection) {
        return null;
    }
}
