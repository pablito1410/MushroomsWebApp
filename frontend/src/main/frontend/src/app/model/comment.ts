import {User} from "./user";
export class Comment {
    id: number;
    content: string;
    dateTime: string;
    user: User;
    answers: Comment[];

    constructor(content, answers) {
        this.content = content;
        this.answers = answers;
    }
}
