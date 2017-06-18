enum Gender {MALE, FEMALE}
enum Role {USER, ADMIN}
export class User {
    id: string;
    username: string;
    firstName: string;
    lastName: string;
    email: string;
    birthDate: string;
    gender: string;
    role: string;
    level: string;
    photo: any;
}