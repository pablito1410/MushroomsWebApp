/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { GravatarComponent } from './gravatar.component';

describe('GravatarComponent', () => {
  let component: GravatarComponent;
  let fixture: ComponentFixture<GravatarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GravatarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GravatarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
