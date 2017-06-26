import {User} from "./user";
export class Comment {
    id: number;
    content: string;
    dateTime: string;
    answers: Comment[]; // TODO

    constructor(content, answers) {
        this.content = content;
        this.answers = answers;
    }
}
