package pl.polsl.mushrooms.application.commands.friend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.polsl.mushrooms.application.commands.ReturningCommand;

import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by pawel_zaqkxkn on 22.05.2017.
 */
public class AddFriendCommand implements ReturningCommand<Collection<Long>> {

    @JsonIgnore
    private String userName;

    @NotNull
    private long[] friendIds;

    protected AddFriendCommand() { }

    public long[] getFriendIds() {
        return friendIds;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    void setFriendIds(final long[] friendIds) {
        this.friendIds = friendIds;
    }
}
