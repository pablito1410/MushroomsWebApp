package pl.polsl.mushrooms.infrastructure.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.Trip;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
                        " TRIP_ID::varchar as       \"id\", " +
                        " DATE_TIME::varchar as              \"dateTime\"," +
                        " PLACE as                  \"place\"");
    };

    public TripProjectionRepository(final JdbcTemplate jdbcTemplate, TripRepository tripRepository, final UserRepository userRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
    }

    public Set<Map<String, Object>> findAll(long userId, ProjectionDao.Projection projection) {
        final ObjectMapper mapper = new ObjectMapper();
        final Mushroomer mushroomer = (Mushroomer)userRepository.findOne(userId);
        final Set<Trip> trips = mushroomer.getTrips();
        final Set<Map<String, Object>> tripsJSON = new HashSet<>();
        trips.forEach(t -> tripsJSON.add(findOne(t.getId(), ProjectionDao.Projection.FULL)));
        return tripsJSON;
    }

    private Map<String, Object> findOne(long id, ProjectionDao.Projection projection) {
        return jdbcTemplate.queryForMap("select " + projections.get(projection) + " from TRIPS where TRIP_ID = ?", id);
    }
}
