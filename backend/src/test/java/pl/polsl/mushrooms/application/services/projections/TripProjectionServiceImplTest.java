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
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.application.services.TripService;
import pl.polsl.mushrooms.application.services.UserService;
import pl.polsl.mushrooms.infrastructure.dto.TripDto;
import pl.polsl.mushrooms.infrastructure.repositories.TripRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;

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
public class TripProjectionServiceImplTest {
    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripProjectionService tripProjectionService;

    @MockBean
    private CreateUserCommand createUserCommand;

    @MockBean
    private CreateTripCommand createTripCommand;

    @Test
    public void findOne() throws Exception {
        //null
    }

    @Test(expected = NullPointerException.class)
    public void findAll() throws Exception {
        //SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @Test
    public void findAll1() throws Exception {
        //SecurityContextHolder.getContext().getAuthentication().getName();
    }

}