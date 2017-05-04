package pl.polsl.mushrooms.application.dao;

import java.util.Map;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 01.05.2017.
 */
public interface UserProjectionDao {

    public enum Projection {
        BASIC,
        FULL
    }

    Map<String,Object> findOne(UUID id, Projection projection);
}
