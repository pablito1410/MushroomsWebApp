
export class DateTool {

    public static getDateTimeDifference(firstDate : Date, secondDate : Date) : number {
        if (firstDate.getDate() > firstDate.getDate()) return 1;
        else if (firstDate.getDate() == firstDate.getDate()) return 0;
        else return -1;
    }
}
