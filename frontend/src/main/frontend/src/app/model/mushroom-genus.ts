import { MushroomFamily } from "./mushroom-family";

/**
 * Model mushroom genus class
 */
export class MushroomGenus {
    
    /** Mushroom genus id */
    id: number;
    /** Name */
    name: string;
    /** Mushroom family */
    family: MushroomFamily;
}