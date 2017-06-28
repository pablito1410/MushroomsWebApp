package pl.polsl.mushrooms.application.services.projections;

import org.hibernate.MappingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.*;
import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;
import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.services.UserService;
import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

/**
 * Created by Artur on 2017-06-26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserProjectionServiceImplTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProjectionService userProjectionService;

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



    @Test
    public void findOne() throws Exception {
        userService.handle(createUserCommand);
        final Mushroomer user = (Mushroomer)userRepository.findByEmail(createUserCommand.getEmail());
        final UserDto result = userProjectionService.findOne(user.getId(), UserProjectionDao.Projection.FULL);
        assertThat(result.getId()).isEqualTo(user.getId());
        assertEquals(result.getUsername(), user.getUsername());
        assertEquals(result.getEmail(), user.getEmail());
    }

    @Test
    public void findOneByUsername() throws Exception {
        userService.handle(createUserCommand);
        final Mushroomer user = (Mushroomer)userRepository.findByEmail(createUserCommand.getEmail());
        final UserDto result = userProjectionService.findOneByUsername(user.getUsername(), UserProjectionDao.Projection.FULL);
        assertThat(result.getId()).isEqualTo(user.getId());
        assertEquals(result.getUsername(), user.getUsername());
        assertEquals(result.getEmail(), user.getEmail());
    }

    @Test
    public void getId() throws Exception {
        userService.handle(createUserCommand);
        final Mushroomer user = (Mushroomer)userRepository.findByEmail(createUserCommand.getEmail());
        final long result = userProjectionService.getId(user.getUsername());
        assertThat(result).isEqualTo(user.getId());
    }

    @Test//(expected = org.modelmapper.MappingException.class)
    public void findAll() throws Exception {
        userService.handle(createUserCommand);
        final Mushroomer user = (Mushroomer)userRepository.findByEmail(createUserCommand.getEmail());
        final Set<MushroomerDto> result = userProjectionService.findAll(user.getUsername(), ProjectionDao.Projection.FULL);
        assertEquals(result.isEmpty(), false);

    }

    @Test//(expected = org.modelmapper.MappingException.class)
    public void findAll1() throws Exception {
        userService.handle(createUserCommand);
        final Mushroomer user = (Mushroomer)userRepository.findByEmail(createUserCommand.getEmail());
        final Set<MushroomerDto> result = userProjectionService.findAll(user.getId(), ProjectionDao.Projection.FULL);
        assertEquals(result.isEmpty(), false);
    }

    @Test
    public void search() throws Exception {
        userService.handle(createUserCommand);
        final Mushroomer user = (Mushroomer)userRepository.findByEmail(createUserCommand.getEmail());
        final Set<MushroomerDto> result = userProjectionService.search(user.getFirstName(), ProjectionDao.Projection.FULL);
        assertEquals(result.isEmpty(), false);
    }

}