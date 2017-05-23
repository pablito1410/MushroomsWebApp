package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.friend.AddFriendCommand;

/**
 * Created by pawel_zaqkxkn on 23.05.2017.
 */
public interface FriendService {

    void handle(AddFriendCommand command);
}
