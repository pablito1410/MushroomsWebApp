package pl.polsl.mushrooms.infrastructure.dao;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.TripProjectionDao;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.Trip;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.TripDto;
import pl.polsl.mushrooms.infrastructure.repositories.TripRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.*;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
@Repository
public class TripProjectionDaoImpl implements TripProjectionDao {


    private final TripRepository tripRepository;
    private final UserRepository userRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    public TripProjectionDaoImpl(TripRepository tripRepository, final UserRepository userRepository) {
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Set<TripDto> findAll(long userId) {
        final User user = Optional.ofNullable(
                userRepository.findOne(userId))
                    .orElseThrow(EntityNotFoundException::new);
        if (user instanceof Mushroomer) {
            final Set<Trip> trips = ((Mushroomer) user).getTrips();
            return map(trips);
        } else {
            throw new IllegalStateException("User is not instance of Mushroomer");
        }
    }

    @Override
    public Set<TripDto> findAll() {
        final List<Trip> trips = tripRepository.findAll();
        return map(trips);
    }

    @Override
    public TripDto findOne(long id) {
        final Trip trip = tripRepository.findOne(id);
        return map(trip);
    }

    @Override
    public Set<TripDto> search(String value) {
        return new HashSet<>();
    }

    private static Set<TripDto> map(Collection<Trip> trips) {
        return modelMapper.map(trips, new TypeToken<Set<TripDto>>() {}.getType());
    }

    private TripDto map(Trip trip) {
        return modelMapper.map(trip, TripDto.class);
    }
}
