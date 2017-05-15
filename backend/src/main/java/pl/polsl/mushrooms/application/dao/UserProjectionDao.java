package pl.polsl.mushrooms.application.dao;

import java.util.Map;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 01.05.2017.
 */
public interface UserProjectionDao extends ProjectionDao {

    Map<String,Object> findOneByUsername(String username, Projection projection);

    Map<String,Object> findOne(UUID id, Projection projection);

    UUID getId(String email);

    Map<String,Object> findAll(UUID id, Projection projection);
}
