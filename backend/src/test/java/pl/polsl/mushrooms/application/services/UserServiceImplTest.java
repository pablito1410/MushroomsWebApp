package pl.polsl.mushrooms.application.services;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
import pl.polsl.mushrooms.application.commands.user.DeleteUsersCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateProfileImageCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateUserCommand;
import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;
import java.util.Date;
import static org.junit.Assert.*;

/**
 * Created by Artur on 2017-06-26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest{

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @MockBean
    private CreateUserCommand createUserCommand;

    @MockBean
    private UpdateProfileImageCommand updateProfileImageCommand;

    @MockBean
    private UpdateUserCommand updateUserCommand;

    @MockBean
    private DeleteUsersCommand deleteUsersCommand;

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
    public void setUpdateProfileImageCommand(){
        updateProfileImageCommand = new UpdateProfileImageCommand(null);
    }

    @Before
    public void setUpdateUserCommand(){
        updateUserCommand = Mockito.mock(UpdateUserCommand.class);
        Mockito.when(updateUserCommand.getFirstName()).thenReturn("hehe");
    }


    @Test
    public void handle() throws Exception {
        userService.handle(createUserCommand);
        final Mushroomer user = (Mushroomer)userRepository.findByEmail(createUserCommand.getEmail());
        assertEquals(createUserCommand.getEmail(), user.getEmail());
        assertEquals(createUserCommand.getFirstName(), user.getFirstName());
    }

    @Test
    public void getUserByEmail() throws Exception {
    }

    @Test(expected = NullPointerException.class)
    public void handle1() throws Exception {
        // SecurityContextHolder.getContext().getAuthentication().getName();
        userService.handle(updateProfileImageCommand);
    }

    @Test(expected = NullPointerException.class)
    public void handle2() throws Exception {
        // SecurityContextHolder.getContext().getAuthentication().getName();
        userService.handle(updateUserCommand);
    }

    @Test(expected = NullPointerException.class)
    public void handle3() throws Exception {
        deleteUsersCommand = Mockito.mock(DeleteUsersCommand.class);
        Mockito.when(deleteUsersCommand.getIds()).then(null);
        userService.handle(deleteUsersCommand);
    }

}