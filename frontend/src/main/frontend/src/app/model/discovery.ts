import {MushroomSpecies} from "./mushroom-species";
import {Score} from "./score";
import {Tag} from "./tag";
export class Discovery {
    id: number;
    tripId: number;
    mushroomSpeciesId: number;
    coordinateX: number;
    coordinateY: number;
    photo: any;
    dateTime: string;
    mushroomSpecies: MushroomSpecies;
    // comments: Array<Comment>;
    isPublic: boolean;
}