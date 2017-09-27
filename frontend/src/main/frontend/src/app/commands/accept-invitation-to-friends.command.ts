
/**
 * Rest command of aaccept invitation to friends
 */
export class AcceptInvitationToFriendsCommand {

    /** Friend identification number */
    friendId: number;

    /**
     * Constructor of class
     * @param friendId  Friend identification number
     */
    constructor(friendId: number) {
        this.friendId = friendId;
    }
}