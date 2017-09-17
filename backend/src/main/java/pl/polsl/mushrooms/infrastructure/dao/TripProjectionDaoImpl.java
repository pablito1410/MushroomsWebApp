package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.TripProjectionDao;
import pl.polsl.mushrooms.application.model.Trip;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.application.model.UsersTrips;
import pl.polsl.mushrooms.infrastructure.dto.TripDto;
import pl.polsl.mushrooms.infrastructure.dto.UsersTripsDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.TripRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UsersTripsRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public class TripProjectionDaoImpl implements TripProjectionDao {


    private final TripRepository tripRepository;
    private final UsersTripsRepository usersTripsRepository;
    private final UserRepository userRepository;
    private final EntityMapper entityMapper;

    public TripProjectionDaoImpl(
            final TripRepository tripRepository,
            final UsersTripsRepository usersTripsRepository,
            final UserRepository userRepository,
            final EntityMapper entityMapper) {
        this.tripRepository = tripRepository;
        this.usersTripsRepository = usersTripsRepository;
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

    @Override
    public Set<UsersTripsDto> findParticipants(final long id) {
        final Set<UsersTrips> participants = usersTripsRepository.findByUsersTripsId_trip_idAndDateTimeIsNotNull(id);
        return entityMapper.map(participants);
    }

    @Override
    public Set<TripDto> findAll(final User user) {
        final List<Trip> trips = tripRepository.findAllAndAccepted(user.getId());
        return entityMapper.map(trips);
    }

    @Override
    public Set<TripDto> findRequests(final User user) {
        final List<Trip> trips = tripRepository.findRequests(user.getId());
        return entityMapper.map(trips);
    }

    @Override
    public Set<UsersTripsDto> findInvited(final long tripId) {
        final Set<UsersTrips> participants = usersTripsRepository.findByUsersTripsId_trip_idAndDateTimeIsNull(tripId);
        return entityMapper.map(participants);
    }
}
