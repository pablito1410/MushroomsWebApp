package pl.polsl.mushrooms.application.commands.friend;

import pl.polsl.mushrooms.application.commands.ReturningCommand;

import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by pawel_zaqkxkn on 20.06.2017.
 */
public class DeleteFriendsCommand implements ReturningCommand<Collection<Long>>{

    @NotNull
    private long[] friendIds;

    protected DeleteFriendsCommand() { }

    public long[] getFriendIds() {
        return friendIds;
    }
}
