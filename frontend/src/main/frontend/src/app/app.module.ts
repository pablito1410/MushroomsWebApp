import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MaterialModule } from '@angular/material';

import { AppComponent } from './components/app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { GravatarComponent } from './components/gravatar/gravatar.component';
import { UserComponent } from './components/user/user.component';
import { UserListComponent } from './components/user-list/user-list.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    GravatarComponent,
    UserComponent,
    UserListComponent
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
    UserListComponent
  ]
})
export class AppModule { }
