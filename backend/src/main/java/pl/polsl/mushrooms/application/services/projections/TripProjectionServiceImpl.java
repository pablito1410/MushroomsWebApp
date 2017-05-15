package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.dao.TripProjectionDao;

import java.util.Map;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public class TripProjectionServiceImpl implements TripProjectionService {


    private final TripProjectionDao tripProjectionDao;

    public TripProjectionServiceImpl(TripProjectionDao tripProjectionDao) {

        this.tripProjectionDao = tripProjectionDao;
    }
    @Override
    public Map<String, Object> findOne(UUID id, ProjectionDao.Projection projection) {
        return null;
    }
}
