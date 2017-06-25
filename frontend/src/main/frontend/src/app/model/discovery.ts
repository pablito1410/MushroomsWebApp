import {MushroomSpecies} from "./mushroom-species";
import {Score} from "./score";
import {Tag} from "./tag";
export class Discovery {
    id: number;
    coordinateX: number;
    coordinateY: number;
    photo: any;
    dateTime: string;
    tripId: number;
    mushroomSpecies: MushroomSpecies;
    mushroomerId: number;
    scores: Array<Score>;
    tags: Array<Tag>;
    comments: Array<Comment>;
}