package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.TripProjectionDao;
import pl.polsl.mushrooms.application.model.Trip;
import pl.polsl.mushrooms.infrastructure.dto.TripDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.TripRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public class TripProjectionDaoImpl implements TripProjectionDao {


    private final TripRepository tripRepository;
    private final UserRepository userRepository;
    private final EntityMapper entityMapper;

    public TripProjectionDaoImpl(
            final TripRepository tripRepository,
            final UserRepository userRepository,
            final EntityMapper entityMapper) {
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
        this.entityMapper = entityMapper;
    }

//    @Override
//    public Set<TripDto> findAll(long userId) {
//        final User user = Optional.ofNullable(
//                userRepository.findOne(userId))
//                    .orElseThrow(EntityNotFoundException::new);
//        if (user instanceof Mushroomer) {
//            final Set<Trip> trips = ((Mushroomer) user).getTrips();
//            return entityMapper.map(trips);
//        } else {
//            throw new IllegalStateException("User is not instance of Mushroomer");
//        }
//    }

    @Override
    public Set<TripDto> findAll() {
        final List<Trip> trips = tripRepository.findAll();
        return entityMapper.map(trips);
}

    @Override
    public TripDto findOne(long id) {
        final Trip trip = tripRepository.findOne(id);
        return entityMapper.map(trip);
    }

    @Override
    public Set<TripDto> search(String value) {
        final Set<Trip> trips = tripRepository.findByPlaceIgnoreCaseContaining(value);
        return entityMapper.map(trips);
    }

}
