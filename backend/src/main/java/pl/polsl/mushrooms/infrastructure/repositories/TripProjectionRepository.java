package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;

import java.util.*;

/**
 * Created by pawel_zaqkxkn on 22.05.2017.
 */
public class TripProjectionRepository {

    private JdbcTemplate jdbcTemplate;
    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    private Map<UserProjectionDao.Projection, String> projections = new HashMap<>();
    {
        projections.put(
                UserProjectionDao.Projection.FULL,
                        " T.TRIP_ID::varchar as       \"id\",\n" +
                        " T.DATE_TIME::varchar as              \"dateTime\",\n" +
                        " T.PLACE as                  \"place\"\n");
    };

    public TripProjectionRepository(final JdbcTemplate jdbcTemplate, TripRepository tripRepository, final UserRepository userRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
    }

    public List<Map<String, Object>> findAll(long userId, ProjectionDao.Projection projection) {

        List<Map<String, Object>> trips = jdbcTemplate.queryForList(
                "SELECT " + projections.get(projection)
                    + " FROM TRIPS T\n"
                    + " LEFT JOIN USERS_TRIPS TS ON TS.TRIP_ID = T.TRIP_ID"
                    + " WHERE TS.USER_ID = ?", userId);

        return trips;
    }

    private Map<String, Object> findOne(long id, ProjectionDao.Projection projection) {
        return jdbcTemplate.queryForMap(
                "SELECT " + projections.get(projection) + " FROM TRIPS T WHERE TRIP_ID = ?", id);
    }
}
