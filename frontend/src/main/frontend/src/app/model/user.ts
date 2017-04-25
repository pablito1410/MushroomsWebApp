enum Gender {MALE, FEMALE}
enum Role {USER, ADMIN}
export class User {
    id: number;
    username: string;
    fistName: string;
    lastName: string;
    email: string;
    password: string;
    birthDate: Date;
    gender: Gender;
    role: Role;
    level: number;
}