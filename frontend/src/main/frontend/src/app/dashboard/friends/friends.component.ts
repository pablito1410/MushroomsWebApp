import {Component, OnInit} from '@angular/core';
import {User} from "../../model/user";

@Component({
    moduleId: module.id,
    selector: 'friends-cmp',
    templateUrl: 'friends.component.html'
})

export class FriendsComponent implements OnInit {
    model: any = {};
    users: User[];

    ngOnInit(){
        this.users = [
            new User('siema'),
            new User('elo'),
            new User('dziala'),
            new User('hallo')
        ]
    }
}