
/**
 * Tool for photo
 */
export class PhotoTool {

    /**
     * Creates photo string to display photo in img tag
     * @param photo     Photo object
     * @return          Photo string to display photo in img tag
     */
    public static getPhotoStringToDisplay(photo: any): string {
        return 'data:image/png;base64,' + photo;
    }
}