
/**
 * Rest command of invite to trip
 */
export class InviteToTripCommand {

    /** Trip identification number */
    tripId: number;
    /** Array with users identification numbers */
    userIds: number[];

    /**
     * Constructor of class
     * @param tripId    Trip identification number
     * @param userIds   Array with users identification numbers
     */
    constructor(tripId: number, userIds: number[]) {
        this.tripId = tripId;
        this.userIds = userIds;
    }
}