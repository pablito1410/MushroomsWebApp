package pl.polsl.mushrooms.application.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.*;
import pl.polsl.mushrooms.application.commands.friend.AddFriendCommand;
import pl.polsl.mushrooms.application.commands.friend.DeleteFriendsCommand;
import java.util.Collection;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

/**
 * Created by Artur on 2017-06-26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendServiceImplTest {
    @Autowired
    private FriendService friendService;

    @MockBean
    private AddFriendCommand addFriendCommand;

    @MockBean
    private DeleteFriendsCommand deleteFriendsCommand;

    @Before
    public void setAddFriendCommand(){
        addFriendCommand = Mockito.mock(AddFriendCommand.class);
        Mockito.when(addFriendCommand.getFriendIds()).thenReturn(null);
    }

    @Test(expected = NullPointerException.class)
    public void handle() throws Exception {
        //SecurityContextHolder.getContext().getAuthentication().getName();
        friendService.handle(addFriendCommand);
    }

    @Test(expected = NullPointerException.class)
    public void handle1() throws Exception {
        //SecurityContextHolder.getContext().getAuthentication().getName();
        deleteFriendsCommand = Mockito.mock(DeleteFriendsCommand.class);
        Mockito.when(deleteFriendsCommand.getFriendIds()).thenReturn(null);
        friendService.handle(deleteFriendsCommand);

    }

}