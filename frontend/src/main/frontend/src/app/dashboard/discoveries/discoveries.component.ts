import {Component, OnInit} from '@angular/core';
import {Discovery} from "../../model/discovery";
import { MdDialog} from "@angular/material";

@Component({
    moduleId: module.id,
    selector: 'discoveries-cmp',
    templateUrl: 'discoveries.component.html'
})
export class DiscoveriesComponent implements OnInit {
    model: any = {};
    discoveries: any[];
    selectedOption: string;

    constructor(public dialog: MdDialog) {}

    ngOnInit(){
        this.discoveries = [
            {id : 'Podgrzybek'},
            {id : 'Maślak'},
            {id : 'Pieczarka'},
            {id : 'Kurka'},
            {id : 'Muchomor'}
        ]
    }

    openAddDiscoveriesDialog() {


    }
}