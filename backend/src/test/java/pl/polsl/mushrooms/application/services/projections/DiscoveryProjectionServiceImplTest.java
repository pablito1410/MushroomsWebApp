package pl.polsl.mushrooms.application.services.projections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.*;
import pl.polsl.mushrooms.application.commands.trip.CreateTripCommand;
import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.dao.TripDao;
import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.Trip;
import pl.polsl.mushrooms.application.services.TripService;
import pl.polsl.mushrooms.application.services.UserService;
import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;
import pl.polsl.mushrooms.infrastructure.repositories.TripRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;
import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
/**
 * Created by Artur on 2017-06-26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscoveryProjectionServiceImplTest {
    @Autowired DiscoveryProjectionService discoveryProjectionService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TripService tripService;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripDao tripDao;

    @MockBean
    private CreateTripCommand createTripCommand;

    @MockBean
    private CreateUserCommand createUserCommand;

    @Before
    public void setCreateUserCommand(){
        Date date = new Date();
        createUserCommand = new CreateUserCommand("username",
                "email@email.com",
                "password",
                "firstName",
                "lastname",
                date,
                Gender.MALE);
    }

    @Before
    public void setCreateTripCommand(){
        LocalDateTime localDateTime = LocalDateTime.now();
        createTripCommand = Mockito.mock(CreateTripCommand.class);
        Mockito.when(createTripCommand.getCoordinateX()).thenReturn(1.2);
        Mockito.when(createTripCommand.getCoordinateY()).thenReturn(2.1);
        Mockito.when(createTripCommand.getDateTime()).thenReturn(localDateTime);
        Mockito.when(createTripCommand.getPlace()).thenReturn("Honolulu");
        Mockito.when(createTripCommand.getRadius()).thenReturn(5.5);
    }

    @Test
    public void findOne() throws Exception {
        //null
    }

    @Test(expected = NullPointerException.class)
    public void findAll() throws Exception {
        // SecurityContextHolder.getContext().getAuthentication().getName();
        userService.handle(createUserCommand);
        final Mushroomer mushroomer = (Mushroomer)userRepository.findByEmail(createUserCommand.getEmail());
        final long tripId = tripService.handle(createTripCommand);
        final Trip trip = tripRepository.getOne(tripId);
        trip.addMushroomer(mushroomer);
        tripDao.save(trip);

        Set<DiscoveryDto> result = discoveryProjectionService.findAll(mushroomer.getUsername(), ProjectionDao.Projection.FULL);
        assertEquals(result.isEmpty(), false);
    }

}