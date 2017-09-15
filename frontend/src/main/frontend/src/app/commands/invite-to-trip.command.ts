
export class InviteToTripCommand {
    tripId: number;
    userIds: number[];

    constructor(tripId: number, userIds: number[]) {
        this.tripId = tripId;
        this.userIds = userIds;
    }
}