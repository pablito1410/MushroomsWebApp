enum Gender {MALE, FEMALE}
enum Role {USER, ADMIN}
export class User {
    constructor(name: string){
        this.username = name;
    }
    id: string;
    username: string;
    firstName: string;
    lastName: string;
    email: string;
    birthDate: string;
    gender: string;
    role: string;
    level: number;
}