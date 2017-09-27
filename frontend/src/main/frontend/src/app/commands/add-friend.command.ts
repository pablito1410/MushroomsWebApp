
/**
 * Rest command of add friend
 */
export class AddFriendCommand {

    /** Array with friends identification numbers */
    friendIds: number[];

    /**
     * Constructor of class
     * @param friendIds Array with friends identification numbers
     */
    constructor(friendIds: number[]) {
        this.friendIds = friendIds;
    }
}