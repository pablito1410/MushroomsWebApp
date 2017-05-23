package pl.polsl.mushrooms.application.dao;

import java.util.Map;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public interface TripProjectionDao extends ProjectionDao {

    Set<Map<String, Object>> findAll(long userId, Projection projection);
}
