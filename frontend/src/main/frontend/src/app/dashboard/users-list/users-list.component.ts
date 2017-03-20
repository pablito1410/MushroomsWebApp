import {Component, OnInit, Input} from '@angular/core';
import {User} from "../../shared/users.service";
import {UserComponent} from "../user/user.component";

@Component({
  selector: 'app-users-list',
  templateUrl: 'users-list.component.html',
  styleUrls: ['users-list.component.css'],
  providers: [UserComponent]
})
export class UsersListComponent implements OnInit {

  @Input() users:Array<User>;

  constructor() { }

  ngOnInit() {
  }

}
