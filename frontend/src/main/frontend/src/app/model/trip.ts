import { Discovery } from "./discovery";

/**
 * Model trip class
 */
export class Trip {
    
    /** Trip id */
    id: number;
    /** Date and time */
    dateTime: string;
    /** Place */
    place: string;
    /** Coordinate x */
    coordinateX: number;
    /** Coordinate y */
    coordinateY: number;
    /** Radius */
    radius: number;
}