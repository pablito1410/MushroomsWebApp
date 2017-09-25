
export class AddScoreCommand {
    discoveryId: number;
    value: number;

    constructor(discoveryId: number, value: number) {
        this.discoveryId = discoveryId;
        this.value = value;
    }
}