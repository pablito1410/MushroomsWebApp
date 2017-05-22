package pl.polsl.mushrooms.infrastructure.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.Trip;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 22.05.2017.
 */
public class TripProjectionRepository {

    private JdbcTemplate jdbcTemplate;
    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    public TripProjectionRepository(final JdbcTemplate jdbcTemplate, TripRepository tripRepository, final UserRepository userRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
    }

    public Map<String,Object> findAll(long userId, ProjectionDao.Projection projection) {
        final ObjectMapper mapper = new ObjectMapper();
        final Mushroomer mushroomer = (Mushroomer)userRepository.findOne(userId);
        final Set<Trip> trips = mushroomer.getTrips();
        return mapper.convertValue(trips, Map.class);
    }
}
