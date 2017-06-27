package pl.polsl.mushrooms.infrastructure.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
import pl.polsl.mushrooms.application.services.UserService;

import static org.mockito.BDDMockito.given;

/**
 * Created by pawel_zaqkxkn on 21.06.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserProjectionRepositoryTest {

    private ModelMapper modelMapper;

    @MockBean
    private UserService userService;

    @MockBean
    private CreateUserCommand command;



    @Before
    public  void setUp() {
        modelMapper = new ModelMapper();
    }

    @Test
    public void findOne() throws Exception {
        given(userService.handle(command)).willReturn(Long.valueOf(3));
        final Long a = userService.handle(command);
    }

}