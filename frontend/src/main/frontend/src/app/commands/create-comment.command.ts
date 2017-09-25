
export class CreateCommentCommand {
    discoveryId: number;
    targetId: number;
    contents: string;
    dateTime: string;

    constructor(targetId: number, discoveryId: number, contents: string, dateTime: string) {
        this.discoveryId = discoveryId;
        this.targetId = targetId;
        this.contents = contents;
        this.dateTime = dateTime;
    }
}