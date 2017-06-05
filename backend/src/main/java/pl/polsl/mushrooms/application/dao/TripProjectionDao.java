package pl.polsl.mushrooms.application.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public interface TripProjectionDao extends ProjectionDao {

    List<Map<String, Object>> findAll(long userId, Projection projection);
}
