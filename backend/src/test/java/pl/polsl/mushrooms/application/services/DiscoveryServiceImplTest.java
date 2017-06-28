package pl.polsl.mushrooms.application.services;

import org.hibernate.sql.Update;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.configuration.injection.MockInjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.*;
import pl.polsl.mushrooms.application.commands.discovery.AddScoreToDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.CreateDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateDiscoveryCommand;
import pl.polsl.mushrooms.infrastructure.repositories.DiscoveryRepository;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
/**
 * Created by Artur on 2017-06-26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscoveryServiceImplTest {
    @Autowired
    private DiscoveryService discoveryService;

    @Autowired
    private DiscoveryRepository discoveryRepository;

    @MockBean
    private CreateDiscoveryCommand createDiscoveryCommand;

    @MockBean
    private UpdateDiscoveryCommand updateDiscoveryCommand;

    @MockBean
    private DeleteDiscoveryCommand deleteDiscoveryCommand;

    @MockBean
    private AddScoreToDiscoveryCommand addScoreToDiscoveryCommand;

    @Before
    public void setCreateDiscoveryCommand(){
        LocalDateTime localDateTime = LocalDateTime.now();
        createDiscoveryCommand = Mockito.mock(CreateDiscoveryCommand.class);
        Mockito.when(createDiscoveryCommand.getCoordinateX()).thenReturn(1.2);
        Mockito.when(createDiscoveryCommand.getCoordinateY()).thenReturn(2.2);
        Mockito.when(createDiscoveryCommand.getDateTime()).thenReturn(localDateTime);
        Mockito.when(createDiscoveryCommand.getMushroomSpieceId()).thenReturn(Long.valueOf(1));
        Mockito.when(createDiscoveryCommand.getPhoto()).thenReturn(null);
        Mockito.when(createDiscoveryCommand.getTags()).thenReturn(null);
        Mockito.when(createDiscoveryCommand.getTripId()).thenReturn(Long.valueOf(1));
    }

    @Before
    public void setUpdateDiscoveryCommand() {
        LocalDateTime localDateTime = LocalDateTime.now();
        updateDiscoveryCommand = Mockito.mock(UpdateDiscoveryCommand.class);
        Mockito.when(updateDiscoveryCommand.getCoordinateX()).thenReturn(1.2);
        Mockito.when(updateDiscoveryCommand.getCoordinateY()).thenReturn(2.2);
        Mockito.when(updateDiscoveryCommand.getDateTime()).thenReturn(localDateTime);
        Mockito.when(updateDiscoveryCommand.getMushroomSpieceId()).thenReturn(Long.valueOf(1));
        Mockito.when(updateDiscoveryCommand.getPhoto()).thenReturn(null);
        Mockito.when(updateDiscoveryCommand.getTags()).thenReturn(null);
        Mockito.when(updateDiscoveryCommand.getId()).thenReturn(Long.valueOf(1));
    }

    @Before
    public void setAddScoreToDiscoveryCommand() {
        addScoreToDiscoveryCommand = Mockito.mock(AddScoreToDiscoveryCommand.class);
        Mockito.when(addScoreToDiscoveryCommand.getDiscoveryId()).thenReturn(Long.valueOf(1));
        Mockito.when(addScoreToDiscoveryCommand.getScore()).thenReturn(1);
    }

    @Test(expected = NullPointerException.class)
    public void handle() throws Exception {
        // SecurityContextHolder.getContext().getAuthentication().getName();
        discoveryService.handle(createDiscoveryCommand);
    }

    @Test(expected = NullPointerException.class)
    public void handle1() throws Exception {
        // SecurityContextHolder.getContext().getAuthentication().getName();
        discoveryService.handle(updateDiscoveryCommand);
    }

    @Test(expected = NullPointerException.class)
    public void handle2() throws Exception {
        // SecurityContextHolder.getContext().getAuthentication().getName();
        deleteDiscoveryCommand = Mockito.mock(DeleteDiscoveryCommand.class);
        Mockito.when(deleteDiscoveryCommand.getId()).thenReturn(Long.valueOf(1));
        discoveryService.handle(deleteDiscoveryCommand);
    }

    @Test(expected = NullPointerException.class)
    public void handle3() throws Exception {
        // SecurityContextHolder.getContext().getAuthentication().getName();
        discoveryService.handle(addScoreToDiscoveryCommand);
    }

}