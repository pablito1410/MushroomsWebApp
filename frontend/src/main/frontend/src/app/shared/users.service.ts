import { Injectable } from '@angular/core';

export interface User {
  id:number;
  name:string;
  age:number;
  email:string;
}

@Injectable()
export class UsersService {

  users:Array<User>;

  constructor() {
    this.users = [{
      id: 1,
      name: 'Tester',
      age: 99,
      email: 'randomemail@com.pl'
    }];
  }
}
