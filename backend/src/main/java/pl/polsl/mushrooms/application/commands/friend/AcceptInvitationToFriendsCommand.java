package pl.polsl.mushrooms.application.commands.friend;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 28.06.2017.
 */
public class AcceptInvitationToFriendsCommand implements VoidCommand {

    @NotNull
    private Long friendId;

    protected AcceptInvitationToFriendsCommand() { }

    public Long getFriendId() {
        return friendId;
    }
}
