package pl.polsl.mushrooms.application.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by pawel_zaqkxkn on 01.05.2017.
 */
public interface UserProjectionDao extends ProjectionDao {

    Map<String,Object> findOneByUsername(String username, Projection projection);

    Map<String,Object> findOne(long id, Projection projection);

    long getId(String email);

    List<Map<String, Object>> findAll(long id, Projection projection);

    List<Map<String,Object>> search(String value, Projection projection);
}
