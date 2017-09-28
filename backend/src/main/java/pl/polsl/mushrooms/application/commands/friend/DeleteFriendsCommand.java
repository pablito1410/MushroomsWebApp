package pl.polsl.mushrooms.application.commands.friend;

import pl.polsl.mushrooms.application.commands.ReturningCommand;
import javax.validation.constraints.NotNull;
import java.util.Collection;

public class DeleteFriendsCommand implements ReturningCommand<Collection<Long>>{

    private String userName;

    @NotNull
    private long[] friendIds;

    protected DeleteFriendsCommand() { }

    public long[] getFriendIds() {
        return friendIds;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}