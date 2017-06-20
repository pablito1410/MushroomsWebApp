package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.friend.AddFriendCommand;
import pl.polsl.mushrooms.application.commands.friend.DeleteFriendsCommand;

import java.util.Collection;

/**
 * Created by pawel_zaqkxkn on 23.05.2017.
 */
public interface FriendService {

    Collection<Long> handle(AddFriendCommand command);

    Collection<Long> handle(DeleteFriendsCommand command);
}
