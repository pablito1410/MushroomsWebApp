import { Component, OnInit } from '@angular/core';
import { UsersService, User } from "./shared/users.service";
import { UsersListComponent } from "./dashboard/users-list/users-list.component";

/**
 *
 */
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css'],
  providers: [
    UsersService,
    UsersListComponent
  ]
})
export class AppComponent implements OnInit {

  /**
   *
   */
  public users:Array<User>;

  /**
   *
   */
  ngOnInit() {
    this.users = this.usersService.users;
  }

  /**
   *
   * @param usersService
   */
  constructor(private usersService: UsersService) {
  }
}
