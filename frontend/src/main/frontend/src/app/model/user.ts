enum Gender {MALE, FEMALE}
enum Role {USER, ADMIN}
export class User {
    id: number;
    username: string;
    firstName: string;
    lastName: string;
    email: string;
    password: string;
    birthDate: string;
    gender: string;
    role: Role;
    level: number;
}