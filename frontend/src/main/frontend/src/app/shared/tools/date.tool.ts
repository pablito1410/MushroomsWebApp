
export class DateTool {

    public static compareDateTime(firstDate : Date, secondDate : Date) : number {
        if ((firstDate.getFullYear() > secondDate.getFullYear())
            && (firstDate.getMonth() > secondDate.getMonth())
            && (firstDate.getDay() > secondDate.getDay())) return 1;
        else if ((firstDate.getFullYear() == secondDate.getFullYear())
            && (firstDate.getMonth() == secondDate.getMonth())
            && (firstDate.getDay() == secondDate.getDay())) return 0;
        else return -1;
    }
}
