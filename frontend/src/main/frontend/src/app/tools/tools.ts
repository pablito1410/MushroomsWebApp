
/**
 * Tools class with helpful methods
 */
export class Tools {

    /**
     * Creates photo string to display photo in img tag
     * @param photo     Photo object
     * @return          Photo string to display photo in img tag
     */
    public static getPhotoStringToDisplay(photo: any): string {
        return 'data:image/png;base64,' + photo;
    }

    /**
     * Converts date to locale string
     * @param date      Date string
     * @returns         Locale date string
     */
    public static convertDateToLocaleString(date: string): string {
        return new Date(date).toLocaleString();
    }
}