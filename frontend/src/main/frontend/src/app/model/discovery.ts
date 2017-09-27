import { MushroomSpecies } from "./mushroom-species";
import { Score } from "./score";
import { Tag } from "./tag";

/**
 * Model discovery class
 */
export class Discovery {

    /** Discovery id */
    id: number;
    /** Trip id */
    tripId: number;
    /** Mushroom species id */
    mushroomSpeciesId: number;
    /** Coordinate x */
    coordinateX: number;
    /** Coordinate y */
    coordinateY: number;
    /** Photo */
    photo: any;
    /** Date and time */
    dateTime: string;
    /** Mushroom species */
    mushroomSpecies: MushroomSpecies;
    /** Is public flag */
    isPublic: boolean;
}