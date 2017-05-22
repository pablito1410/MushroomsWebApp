package pl.polsl.mushrooms.infrastructure.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.04.2017.
 */

public class UserProjectionRepository {

    private JdbcTemplate jdbcTemplate;
    private final UserRepository userRepository;

    private Map<UserProjectionDao.Projection, String> projections = new HashMap<>();
    {
        projections.put(UserProjectionDao.Projection.BASIC, " USERNAME, EMAIL");
        projections.put(
                UserProjectionDao.Projection.FULL,
                " USER_ID::varchar as        \"id\", " +
                " USERNAME as       \"username\"," +
                " FIRST_NAME as     \"firstName\"," +
                " LAST_NAME as      \"lastName\"," +
                " EMAIL as          \"email\"," +
                " BIRTH_DATE as     \"birthDate\"," +
                " GENDER as         \"gender\"," +
                " ROLE as           \"role\"," +
                " LEVEL as          \"level\"");
    };

    public UserProjectionRepository(final JdbcTemplate jdbcTemplate, final UserRepository userRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRepository = userRepository;
    }

    public Map<String,Object> findOne(long id, ProjectionDao.Projection projection) {
        return jdbcTemplate.queryForMap("select " + projections.get(projection) + " from USERS where USER_ID = ?", id);
    }

    public Map<String, Object> findOneByUsername(String email, ProjectionDao.Projection projection) {
        return jdbcTemplate.queryForMap("select " + projections.get(projection) + " from USERS where USERNAME = ?", email);
    }

    public Long getId(String email) {
        // TODO zwracac malego longa lub rzuca wyjatkiem
        return jdbcTemplate.queryForObject("select UserId from USERS where EMAIL = ?", Long.class, email);
    }

    public Map<String,Object> findAll(long id, ProjectionDao.Projection projection) {
        final ObjectMapper mapper = new ObjectMapper();
        final User user = userRepository.findOne(id);

        switch(user.getRole()) {

            case ADMIN:
                throw new UnsupportedOperationException(String.format("User type %s has no friends.", user.getRole()));

            case MUSHROOMER:
                return mapper.convertValue(((Mushroomer)user).getFriends(), Map.class);

                default:
                    throw new RuntimeException(String.format("Unhandled switch exception - %s", user.getRole()));
        }
    }
}
