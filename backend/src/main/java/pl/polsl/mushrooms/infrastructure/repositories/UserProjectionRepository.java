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
        projections.put(
                UserProjectionDao.Projection.FULL,
                " USER_ID as        \"userId\", " +
                " USERNAME as       \"username\"," +
                " FIRST_NAME as     \"firstName\"," +
                " LAST_NAME as      \"lastName\"," +
                " EMAIL as          \"email\"," +
                " BIRTH_DATE as     \"birthDate\"," +
                " GENDER as         \"gender\"," +
                " LEVEL as          \"level\"");
    };

    public UserProjectionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String,Object> findOne(UUID id, UserProjectionDao.Projection projection) {
        return jdbcTemplate.queryForMap("select " + projections.get(projection) + " from USERS where USER_ID = ?", id);
    }

    public Map<String, Object> findOneByUsername(String email, UserProjectionDao.Projection projection) {
        return jdbcTemplate.queryForMap("select " + projections.get(projection) + " from USERS where USERNAME = ?", email);
    }



}
