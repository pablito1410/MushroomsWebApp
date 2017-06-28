package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;

import java.util.Map;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public interface DiscoveryProjectionService {
    Map<String,Object> findOne(long id, ProjectionDao.Projection projection);

    Set<DiscoveryDto> findAll(String userName, ProjectionDao.Projection projection);

    Set<DiscoveryDto> search(String value);
}
