import {Trip} from "./trip";
import {Score} from "./score";
import {Discovery} from "./discovery";
// enum Gender {MALE, FEMALE}
// enum Role {USER, ADMIN}
export class User {
    id: number;
    username: string;
    email: string;
    firstName: string;
    lastName: string;
    birthDate: string;
    gender: string;
    level: string;
    country: string;
    city: string;
    photo: any;
}