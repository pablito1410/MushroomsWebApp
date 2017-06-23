package pl.polsl.mushrooms.infrastructure.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.application.enums.MushroomerLevel;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;

import java.util.Date;

/**
 * Created by pawel_zaqkxkn on 21.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserProjectionRepositoryTest {

    private ModelMapper modelMapper;

    @Before
    public  void setUp() {
        modelMapper = new ModelMapper();
    }

    @Test
    public void findOne() throws Exception {
        final Mushroomer user = new Mushroomer("pablito", "pablito@gmail.com", "asdf", "qwer", "rtyu", new Date(), Gender.FEMALE, MushroomerLevel.BEGINNER);
        final MushroomerDto userDto = modelMapper.map(user, MushroomerDto.class);

    }

}