
/**
 * Rest command of create comment
 */
export class CreateCommentCommand {

    /** Discovery identification number */
    discoveryId: number;
    /** Target comment identification number */
    targetId: number;
    /** Contensts of comment */
    contents: string;
    /** Date and time of comment */
    dateTime: string;

    /**
     * Constructor of class
     * @param targetId      Target comment identification number
     * @param discoveryId   Discovery identification number
     * @param contents      Contensts of comment
     * @param dateTime      Date and time of comment
     */
    constructor(targetId: number, discoveryId: number, contents: string, dateTime: string) {
        this.discoveryId = discoveryId;
        this.targetId = targetId;
        this.contents = contents;
        this.dateTime = dateTime;
    }
}