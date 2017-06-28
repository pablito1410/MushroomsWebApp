package pl.polsl.mushrooms.application.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.polsl.mushrooms.application.commands.score.AddScoreCommand;
import pl.polsl.mushrooms.infrastructure.repositories.ScoreRepository;

import java.time.LocalDateTime;

/**
 * Created by Artur on 2017-06-26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoreServiceImplTest {
    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ScoreRepository scoreRepository;

    @MockBean
    private AddScoreCommand addScoreCommand;

    @Before
    public void setAddScoreCommand(){
        LocalDateTime localDateTime = LocalDateTime.now();
        addScoreCommand = Mockito.mock(AddScoreCommand.class);
        Mockito.when(addScoreCommand.getDateTime()).thenReturn(localDateTime);
        Mockito.when(addScoreCommand.getDiscoveryId()).thenReturn(Long.valueOf(1));
        Mockito.when(addScoreCommand.getValue()).thenReturn(1);
    }


    @Test(expected = NullPointerException.class)
    public void handle() throws Exception {
        //SecurityContextHolder.getContext().getAuthentication().getName();
        scoreService.handle(addScoreCommand);
    }

}