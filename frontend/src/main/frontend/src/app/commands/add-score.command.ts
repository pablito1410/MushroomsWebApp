
/**
 * Rest command of add score
 */
export class AddScoreCommand {

    /** Discovery identification number */
    discoveryId: number;
    /** Score value */
    value: number;

    /**
     * Constructor of class
     * @param discoveryId   Discovery identification number
     * @param value         Score value
     */
    constructor(discoveryId: number, value: number) {
        this.discoveryId = discoveryId;
        this.value = value;
    }
}