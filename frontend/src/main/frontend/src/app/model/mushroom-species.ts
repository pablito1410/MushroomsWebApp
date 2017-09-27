import { MushroomGenus } from "./mushroom-genus";

/**
 * Model mushroom species class
 */
export class MushroomSpecies {
    
    /** Mushroom species id */
    id: number;
    /** Name */
    name: string;
    /** Example photo */
    examplePhoto: any;
    /** Mushroom genus id */
    genus: MushroomGenus;
}