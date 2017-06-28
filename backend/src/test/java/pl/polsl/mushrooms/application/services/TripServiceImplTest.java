package pl.polsl.mushrooms.application.services;

import org.apache.tomcat.jni.Local;
import org.hibernate.LazyInitializationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.polsl.mushrooms.application.commands.trip.*;
import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateUserCommand;
import pl.polsl.mushrooms.application.dao.TripDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.application.enums.MushroomerLevel;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.Trip;
import pl.polsl.mushrooms.infrastructure.repositories.TripRepository;
import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

/**
 * Created by Artur on 2017-06-26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TripServiceImplTest {

    @Autowired
    private TripService tripService;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripDao tripDao;

    @Autowired
    private UserDao userDao;

    @MockBean
    private CreateTripCommand createTripCommand;

    @MockBean
    private UpdateTripCommand updateTripCommand;

    @MockBean
    private DeleteTripCommand deleteTripCommand;

    @MockBean
    private JoinTripCommand joinTripCommand;

    @MockBean
    private InviteToTripCommand inviteToTripCommand;

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

    @Before
    public void setUpdateTripCommand(){
        LocalDateTime localDateTime = LocalDateTime.now();
        updateTripCommand = Mockito.mock(UpdateTripCommand.class);
        Mockito.when(updateTripCommand.getDateTime()).thenReturn(localDateTime);
        Mockito.when(updateTripCommand.getPlace()).thenReturn("Polska");
    }

    @Before
    public void setJoinTripCommand(){
        joinTripCommand = Mockito.mock(JoinTripCommand.class);
        Mockito.when(joinTripCommand.getTripId()).thenReturn(Long.valueOf(1));
    }

    @Before
    public void setInviteToTripCommand() {
        inviteToTripCommand = Mockito.mock(InviteToTripCommand.class);
    }

    @Test(expected = NullPointerException.class)
    public void handle() throws Exception {
        // SecurityContextHolder.getContext().getAuthentication().getName();
        final long tripId = tripService.handle(createTripCommand);
        final Trip trip = tripRepository.getOne(tripId);
        assertEquals(createTripCommand.getDateTime(), trip.getDateTime());
        assertEquals(createTripCommand.getPlace(), trip.getPlace());
    }

    @Test
    public void handle1() throws Exception {
        Trip trip = new Trip(
                createTripCommand.getDateTime(),
                createTripCommand.getPlace(),
                createTripCommand.getCoordinateX(),
                createTripCommand.getCoordinateY(),
                createTripCommand.getRadius()
        );
        tripDao.save(trip);
        Mockito.when(updateTripCommand.getTripId()).thenReturn(trip.getId());
        tripService.handle(updateTripCommand);
        assertEquals(createTripCommand.getPlace(), trip.getPlace());
        assertEquals(createTripCommand.getDateTime(), trip.getDateTime());
    }

    @Test(expected = NullPointerException.class)
    public void handle2() throws Exception {
        // SecurityContextHolder.getContext().getAuthentication().getName();
        Mockito.when(deleteTripCommand.getTripId()).then(null);
        tripService.handle(deleteTripCommand);
    }

    @Test(expected = NullPointerException.class)
    public void handle3() throws Exception {
        // SecurityContextHolder.getContext().getAuthentication().getName();
        tripService.handle(joinTripCommand);
    }

    @Test(expected = LazyInitializationException.class)
    public void handle4() throws Exception {
        Trip trip = new Trip(
                createTripCommand.getDateTime(),
                createTripCommand.getPlace(),
                createTripCommand.getCoordinateX(),
                createTripCommand.getCoordinateY(),
                createTripCommand.getRadius()
        );
        tripDao.save(trip);
        Mockito.when(inviteToTripCommand.getTripId()).thenReturn(trip.getId());

        Date date = new Date();
        Mushroomer mushroomer = new Mushroomer(
                "username",
                "email@email.com",
                "pass",
                "firstName",
                "lastName",
                date,
                Gender.MALE,
                MushroomerLevel.BEGINNER
        );
        userDao.save(mushroomer);
        Mockito.when(inviteToTripCommand.getUserId()).thenReturn(mushroomer.getId());
        tripService.handle(inviteToTripCommand);
        assertEquals(trip.getMushroomers().contains(mushroomer), true);
    }

}