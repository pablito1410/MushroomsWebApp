import { Component, OnInit } from '@angular/core';

/**
 *
 */
interface Something {

  /**
   *
   */
  title:string;

  /**
   *
   */
  check:boolean;
}

/**
 *
 */
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css']
})
export class AppComponent implements OnInit {

  /**
   *
   * @type {string}
   */
  public newSomethingTitle:string ;

  /**
   *
   */
  public somethingArray:Array<Something>;

  /**
   *
   */
  ngOnInit() {
  }

  /**
   *
   */
  constructor() {
    this.newSomethingTitle = '';
    this.somethingArray = [{
      title: 'witam',
      check: false
    }, {
      title: 'dziala',
      check: true
    }];
  }

  /**
   *
   */
  addSomething() {
    if (!this.newSomethingTitle) {
      return;
    }
    const newSomething:Something = {
      title: this.newSomethingTitle,
      check: false
    };
    this.somethingArray.push(newSomething);
    this.newSomethingTitle = '';
  }
}
