package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.dao.TripProjectionDao;

import java.util.List;
import java.util.Map;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public class TripProjectionServiceImpl implements TripProjectionService {


    private final TripProjectionDao tripProjectionDao;
    private final UserProjectionService userProjectionService;

    public TripProjectionServiceImpl(TripProjectionDao tripProjectionDao, final UserProjectionService userProjectionService) {

        this.tripProjectionDao = tripProjectionDao;
        this.userProjectionService = userProjectionService;
    }
    @Override
    public Map<String, Object> findOne(long id, ProjectionDao.Projection projection) {
        return null;
    }

    @Override
    public List<Map<String, Object>> findAll(String userName, ProjectionDao.Projection projection) {
        final long userId = userProjectionService.getId(userName);
        return tripProjectionDao.findAll(userId, projection);
    }

    @Override
    public List<Map<String, Object>> findAll(long userId, ProjectionDao.Projection projection) {
        return tripProjectionDao.findAll(userId, projection);
    }
}
