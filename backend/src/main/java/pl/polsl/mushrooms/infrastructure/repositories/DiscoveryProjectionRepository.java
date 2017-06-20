package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pawel_zaqkxkn on 23.05.2017.
 */
public class DiscoveryProjectionRepository {

    private JdbcTemplate jdbcTemplate;
    private final DiscoveryRepository discoveryRepository;
    private final UserRepository userRepository;

    public DiscoveryProjectionRepository(final JdbcTemplate jdbcTemplate, DiscoveryRepository discoveryRepository, final UserRepository userRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.discoveryRepository = discoveryRepository;
        this.userRepository = userRepository;
    }


    private Map<UserProjectionDao.Projection, String> projections = new HashMap<>();
    {
        projections.put(
                UserProjectionDao.Projection.FULL,
                        " D.DISCOVERY_ID::varchar as \"id\",\n" +
                        " D.COORDINATE_X::varchar as \"coordinateX\",\n" +
                        " D.COORDINATE_Y::varchar as \"coordinateY\",\n" +
                        " D.PHOTO as \"photo\",\n" +
                        " D.DATE_TIME as \"dateTime\"\n");
    }

    public List<Map<String, Object>> findAll(long userId, ProjectionDao.Projection projection) {

        List<Map<String, Object>> discoveries = jdbcTemplate.queryForList(
                "SELECT " + projections.get(projection) + "\n"
                        + " FROM DISCOVERIES D\n"
                        + " WHERE D.USER_ID = ?", userId);

        return discoveries;
    }

    private Map<String, Object> findOne(long id, ProjectionDao.Projection projection) {
        return jdbcTemplate.queryForMap(
                "SELECT" + projections.get(projection) +
                        " FROM DISCOVERIES D WHERE D.DISCOVERY_ID = ?", id);
    }
}
