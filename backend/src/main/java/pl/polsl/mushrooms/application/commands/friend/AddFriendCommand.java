package pl.polsl.mushrooms.application.commands.friend;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 22.05.2017.
 */
public class AddFriendCommand implements VoidCommand {

    private String username;

    @NotNull
    private long friendId;

    protected AddFriendCommand() { }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public void setFriendId(long friendId) {
        this.friendId = friendId;
    }

    public long getFriendId() {
        return friendId;
    }
}
