export class Trip {
    id: number;
    place: string;
    dateTime: Date;

     status(): string {
        let now = new Date();
        if (this.dateTime.getTime() > now.getTime()) {
            return 'Upcoming';
        }
        else if (this.dateTime.getTime() < now.getTime()) {
            return 'Past';
        }
        else {
            return 'Now';
        }
    }
}