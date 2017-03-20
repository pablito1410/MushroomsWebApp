import {Component, OnInit, Input} from '@angular/core';
import {User} from "../../shared/users.service";
import {GravatarComponent} from "../gravatar/gravatar.component";

@Component({
  selector: 'app-user',
  templateUrl: 'user.component.html',
  styleUrls: ['user.component.css'],
  providers: [GravatarComponent]
})
export class UserComponent implements OnInit {

  @Input() user:User;

  constructor() { }

  ngOnInit() {
  }

}
