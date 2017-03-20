import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MaterialModule } from '@angular/material';

import { AppComponent } from './app.component';
import { NavbarComponent } from './dashboard/navbar/navbar.component';
import { GravatarComponent } from './dashboard/gravatar/gravatar.component';
import { UserComponent } from './dashboard/user/user.component';
import { UsersListComponent } from './dashboard/users-list/users-list.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    GravatarComponent,
    UserComponent,
    UsersListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    MaterialModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [
    AppComponent,
    NavbarComponent,
    GravatarComponent,
    UserComponent,
    UsersListComponent
  ]
})
export class AppModule { }
