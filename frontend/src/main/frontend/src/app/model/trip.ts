import {Discovery} from "./discovery";
export class Trip {
    id: number;
    dateTime: string;
    place: string;
    mushroomersIds: Array<number>;
    discoveries: Array<Discovery>;

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