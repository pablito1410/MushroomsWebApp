import { User } from "./user";

/**
 * Model comment class
 */
export class Comment {
    /** Comment id */
    id: number;
    /** Content */
    content: string;
    /** Date and time */
    dateTime: string;
    /** User */
    user: User;
    /** Array with answers */
    answers: Comment[];

    /**
     * Additional constructor of class
     * @param content       Content
     * @param answers       Array with answers
     */
    constructor(content: string, answers: Comment[]) {
        this.content = content;
        this.answers = answers;
    }
}
