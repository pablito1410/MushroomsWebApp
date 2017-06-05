import {Component, OnInit, Inject} from "@angular/core";
import {MdDialogRef, MD_DIALOG_DATA} from "@angular/material";
import {User} from "../../../model/user";

@Component({
    moduleId: module.id,
    selector: 'friend-details-cmp',
    templateUrl: 'friend-details.component.html'
})
export class FriendDetailsComponent implements OnInit {
    user: any;
    constructor(public dialogRef: MdDialogRef<FriendDetailsComponent>) { }
    ngOnInit() {
        this.user = {
            id: 1,
            username: 'mati',
            firstName: 'Mateusz',
            lastName: 'Nowak',
            email: 'email@email.com',
            birthDate: '22.10.1995',
            gender: 'male',
            role: 'admin',
            level: 'beginner'
        };
    }
}