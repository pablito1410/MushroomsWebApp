package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.friend.AcceptInvitationToFriendsCommand;
import pl.polsl.mushrooms.application.commands.friend.AddFriendCommand;
import pl.polsl.mushrooms.application.commands.friend.DeleteFriendsCommand;

import java.util.Collection;


public interface FriendService {

    /**
     * Sends an invitation to the friends or accepts an invitation from this friend
     * which did sent the invitation earlier.
     * @param command
     * @return Ids of the invited friends
     */
    Collection<Long> handle(AddFriendCommand command);

    /**
     * Removes the friends
     * @param command
     * @return Ids of removed friends
     */
    Collection<Long> handle(DeleteFriendsCommand command);

    /**
     * Accepts the invitation to friends
     * @param command
     */
    void handle(AcceptInvitationToFriendsCommand command);
}
