package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.dao.TripProjectionDao;
import pl.polsl.mushrooms.infrastructure.dto.TripDto;

import java.util.Map;
import java.util.Set;

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
    public Set<TripDto> findAll(String userName, ProjectionDao.Projection projection) {
        final long userId = userProjectionService.getId(userName); // TODO wczytać usera od razu
        return tripProjectionDao.findAll(userId, projection);
    }

    @Override
    public Set<TripDto> findAll(long userId, ProjectionDao.Projection projection) {
        return tripProjectionDao.findAll(userId, projection);
    }
}
