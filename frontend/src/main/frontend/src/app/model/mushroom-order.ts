import { MushroomClass } from "./mushroom-class";

/**
 * Model mushroom order class
 */
export class MushroomOrder {
    
    /** Mushroom order id */
    id: number;
    /** Name */
    name: string;
    /** Mushroom class */
    mushroomClass: MushroomClass;
}