import {User} from "./user";
export class Comment {
    id: number;
    content: string;
    dateTime: string;
    user: User;
    answers: Array<Comment>;
    expanded: boolean;
    textBox: boolean;

    constructor(content, answers) {
        this.expanded = false;
        this.textBox = false;
        this.content = content;
        this.answers = answers;
    }

    toggle() {
        this.expanded = !this.expanded;
        this.textBox = false;
    }

    write() {
        this.textBox = true;
        this.expanded = true;
    }

    cancel() {
        this.textBox = false;
    }

    ok() {
        this.textBox = false;
    }
}
