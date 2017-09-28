package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.TripDao;
import pl.polsl.mushrooms.application.dao.TripProjectionDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Trip;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.application.model.UsersTrips;
import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.dto.TripDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;


public class TripProjectionServiceImpl implements TripProjectionService {


    private final TripProjectionDao tripProjectionDao;
    private final UserDao userDao;
    private final TripDao tripDao;
    private final EntityMapper entityMapper;

    public TripProjectionServiceImpl(
            final TripProjectionDao tripProjectionDao,
            final UserDao userDao,
            final TripDao tripDao, final EntityMapper entityMapper) {

        this.tripProjectionDao = tripProjectionDao;
        this.userDao = userDao;
        this.tripDao = tripDao;
        this.entityMapper = entityMapper;
    }
    @Override
    public TripDto findOne(long id) {
        return tripProjectionDao.findOne(id);
    }

    @Override
    public Set<TripDto> findAll(String userName) {
        final User user = userDao.findOneByUsername(userName)
                .orElseThrow(EntityNotFoundException::new);
        if (user.isAdmin()) {
            return tripProjectionDao.findAll();
        } else {
            return tripProjectionDao.findAll(user);
        }
    }

    @Override
    public Set<TripDto> search(String value) {
        return tripProjectionDao.search(value);
    }

    @Override
    public Set<MushroomerDto> findParticipants(final long id) {
        return tripProjectionDao.findParticipants(id);
    }

    @Override
    public Set<TripDto> findRequests(final String userName) {
        final User user = userDao.findOneByUsername(userName)
                .orElseThrow(EntityNotFoundException::new);

        return tripProjectionDao.findRequests(user);
    }

    @Override
    public Set<MushroomerDto> findInvited(final long tripId) {
        return tripProjectionDao.findInvited(tripId);
    }

    @Override
    public LocalDateTime acceptDateTime(final String userName, final long tripId) {
        final User user = userDao.findOneByUsername(userName)
                .orElseThrow(EntityNotFoundException::new);
        final Trip trip = Optional.ofNullable(tripDao.findTrip(tripId))
                .orElseThrow(EntityNotFoundException::new);
        final UsersTrips usersTrips = Optional.ofNullable(tripProjectionDao.findUserTrip(user, trip))
                .orElseThrow(EntityNotFoundException::new);
        if (usersTrips.getDateTime() == null) {
            throw new EntityNotFoundException();
        } else {
            return usersTrips.getDateTime();
        }
    }

}
