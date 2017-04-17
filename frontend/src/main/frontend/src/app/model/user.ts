enum Gender {MALE, FEMALE}
enum Role {USER, ADMIN}
export class User {
    id: number;
    email: string;
    nick: string;
    passwordHash: string;
    age: number;
    gender: Gender;
    role: Role;
}