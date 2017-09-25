
export class AcceptInvitationToFriendsCommand {
    friendId: number;

    constructor(friendId: number) {
        this.friendId = friendId;
    }
}