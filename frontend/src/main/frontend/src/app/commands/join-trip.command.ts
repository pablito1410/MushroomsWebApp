
/**
 * Rest command of join trip
 */
export class JoinTripCommand {
    
    /** Trip identification number */
    tripId: number;

    /**
     * Constructor of class
     * @param tripId    Trip identification number
     */
    constructor(tripId: number) {
        this.tripId = tripId;
    }
}