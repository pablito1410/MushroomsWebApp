package pl.polsl.mushrooms.application.commands.friend;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 22.05.2017.
 */
public class AddFriendCommand implements VoidCommand {

    @NotNull
    private long[] friendIds;

    protected AddFriendCommand() { }

    public long[] getFriendIds() {
        return friendIds;
    }
}
