package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;
import pl.polsl.mushrooms.application.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                " U.USER_ID::varchar as        \"id\", " +
                " U.USERNAME as       \"username\"," +
                " U.FIRST_NAME as     \"firstName\"," +
                " U.LAST_NAME as      \"lastName\"," +
                " U.EMAIL as          \"email\"," +
                " U.BIRTH_DATE as     \"birthDate\"," +
                " U.GENDER as         \"gender\"," +
                " U.ROLE as           \"role\"," +
                " U.LEVEL as          \"level\"," +
                " U.PHOTO as          \"photo\"");
    };

    public UserProjectionRepository(final JdbcTemplate jdbcTemplate, final UserRepository userRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRepository = userRepository;
    }

    public Map<String,Object> findOne(long id, ProjectionDao.Projection projection) {
        return jdbcTemplate.queryForMap("select " + projections.get(projection) + " from USERS U where U.USER_ID = ?", id);
    }

    public Map<String, Object> findOneByUsername(String email, ProjectionDao.Projection projection) {
        return jdbcTemplate.queryForMap("select " + projections.get(projection) + " from USERS U where U.USERNAME = ?", email);
    }

    public Long getId(String userName) {
        // TODO zwracac malego longa lub rzuca wyjatkiem
        return jdbcTemplate.queryForObject("select USER_ID from USERS where USERNAME = ?", Long.class, userName);
    }

    public List<Map<String,Object>> findAll(long id, ProjectionDao.Projection projection) {
        final User user = userRepository.findOne(id);


        switch(user.getRole()) {

            case ADMIN:
                throw new UnsupportedOperationException(String.format("User type %s has no friends.", user.getRole()));

            case MUSHROOMER:
                List<String> friendIds = jdbcTemplate.queryForList(
                        "SELECT FRIEND_ID::varchar \n"
                                + " FROM USERS_USERS\n"
                                + " WHERE USER_ID = ?",
                        String.class,
                        id);

                List<Map<String, Object>> friends = new ArrayList<>();

                friendIds.forEach(t -> friends.add(findOne(Long.valueOf(t), ProjectionDao.Projection.FULL)));

                return friends;

                default:
                    throw new RuntimeException(String.format("Unhandled switch exception - %s", user.getRole()));
        }
    }


    public List<Map<String,Object>> search(String value, ProjectionDao.Projection projection) {

        List<Map<String, Object>> users = jdbcTemplate.queryForList(
                "SELECT " + projections.get(projection)
                        + " FROM USERS U\n"
                        + " WHERE "
                        + " U.USERNAME LIKE ?"
                        + " OR U.FIRST_NAME LIKE ?",
                "%" + value + "%", "%" + value + "%");

        return users;
    }
}
