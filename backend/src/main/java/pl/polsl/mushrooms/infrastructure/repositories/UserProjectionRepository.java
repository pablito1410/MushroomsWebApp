package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.04.2017.
 */

public class UserProjectionRepository {

    private JdbcTemplate jdbcTemplate;

    private Map<UserProjectionDao.Projection, String> projections = new HashMap<>();
    {
        projections.put(UserProjectionDao.Projection.BASIC, " USERNAME, EMAIL");
        projections.put(UserProjectionDao.Projection.FULL, " USERNAME, EMAIL, FIRST_NAME, LAST_NAME");
    };

    public UserProjectionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String,Object> findOne(UUID id, UserProjectionDao.Projection projection) {
        return jdbcTemplate.queryForMap("select " + projection + "from USERS where id = " + id);
    }


}
