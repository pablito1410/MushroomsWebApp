
export class AddFriendCommand {
    friendIds: number[];

    constructor(friendIds: number[]) {
        this.friendIds = friendIds;
    }
}