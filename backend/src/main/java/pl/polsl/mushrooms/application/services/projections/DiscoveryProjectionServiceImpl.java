package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.DiscoveryProjectionDao;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;

import java.util.Map;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public class DiscoveryProjectionServiceImpl implements DiscoveryProjectionService {

    private final DiscoveryProjectionDao discoveryProjectionDao;
    private final UserProjectionService userProjectionService;

    public DiscoveryProjectionServiceImpl(DiscoveryProjectionDao discoveryProjectionDao, final UserProjectionService userProjectionService) {

        this.discoveryProjectionDao = discoveryProjectionDao;
        this.userProjectionService = userProjectionService;
    }

    @Override
    public Map<String, Object> findOne(long id, ProjectionDao.Projection projection) {
        return null;
    }

    @Override
    public Set<DiscoveryDto> findAll(String userName, ProjectionDao.Projection projection) {
        final long userId = userProjectionService.getId(userName);
        return discoveryProjectionDao.findAll(userId, projection);
    }

    @Override
    public Set<DiscoveryDto> search(String value) {
        return discoveryProjectionDao.search(value);
    }
}
