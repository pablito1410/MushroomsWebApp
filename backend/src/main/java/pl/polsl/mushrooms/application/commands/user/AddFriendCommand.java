package pl.polsl.mushrooms.application.commands.user;

import pl.polsl.mushrooms.application.commands.VoidCommand;

/**
 * Created by pawel_zaqkxkn on 22.05.2017.
 */
public class AddFriendCommand implements VoidCommand {

    private long userId;
    private long friendId;

    protected AddFriendCommand() { }

    public long getUserId() {
        return userId;
    }

    public long getFriendId() {
        return friendId;
    }
}
