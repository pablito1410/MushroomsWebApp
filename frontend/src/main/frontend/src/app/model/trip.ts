import {Discovery} from "./discovery";
export class Trip {
    id: number;
    dateTime: string;
    place: string;
    coordinateX: number;
    coordinateY: number;
    radius: number;

    // status(): string {
    //     let now = new Date();
    //     if (this.dateTime.getTime() > now.getTime()) {
    //         return 'Upcoming';
    //     }
    //     else if (this.dateTime.getTime() < now.getTime()) {
    //         return 'Past';
    //     }
    //     else {
    //         return 'Now';
    //     }
    // }
}