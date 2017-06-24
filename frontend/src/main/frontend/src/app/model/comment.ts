import {User} from "./user";
export class Comment {
    id: number;
    contents: string;
    dateTime: string;
    targetId: number;
    user: User;
    answers: Array<Comment>;

    constructor(contents, answers) {
        this.contents = contents;
        this.answers = answers;
    }
}
