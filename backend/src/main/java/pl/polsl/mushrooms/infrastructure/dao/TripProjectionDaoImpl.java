package pl.polsl.mushrooms.infrastructure.dao;

import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.TripProjectionDao;
import pl.polsl.mushrooms.infrastructure.repositories.TripProjectionRepository;

import java.util.Map;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
@Repository
public class TripProjectionDaoImpl implements TripProjectionDao {


    private final TripProjectionRepository tripProjectionRepository;

    public TripProjectionDaoImpl(TripProjectionRepository tripProjectionRepository) {
        this.tripProjectionRepository = tripProjectionRepository;
    }

    @Override
    public Set<Map<String, Object>> findAll(long userId, Projection projection) {
        return tripProjectionRepository.findAll(userId, projection);
    }
}
