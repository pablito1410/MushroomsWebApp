import { Component, OnInit, Inject } from '@angular/core';
import { UserService } from "../../services/user.service";
import { MdSnackBar } from "@angular/material";
import { DOCUMENT } from "@angular/platform-browser";
import { User } from "../../model/user";
import { Tools } from "../../tools/tools";

/**
 * User page component
 */
@Component({
    moduleId: module.id,
    selector: 'user-cmp',
    templateUrl: 'user.component.html'
})
export class UserComponent implements OnInit {

    /** Model user object */
    user: User;
    /** Flag indicating whether to display the loading animated icon */
    loading: boolean;
    /** Image src */
    imageSrc: string;
    /** File for image */
    file: File;
    /** Input date */
    inputDate: Date;

    /** Static method get photo string to display assignment */
    getPhotoStringToDisplay = Tools.getPhotoStringToDisplay;

    /**
     * Constructor of class
     * @param userService       User service
     * @param snackBar          Material snack bar
     * @param document          Current document
     */
    constructor(
        private userService: UserService,
        public snackBar: MdSnackBar,
        @Inject(DOCUMENT) private document) {
        this.user = new User();
        this.inputDate = new Date();
        this.loading = false;
    }

    /**
     * Initialization method
     */
    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this.initFakeData();
        } else {
            this.userService.get().subscribe(
                result => {
                    this.user = result;
                    if (this.user.birthDate != null && this.user.birthDate != '')
                        this.inputDate = new Date(this.user.birthDate);
                    // bug with overlapping floating labels and inputs values
                    // document.getElementById('email').nodeValue += ' ';
                    // document.getElementById('email').nodeValue.slice(0, -1);
                    // document.getElementById('username').nodeValue += ' ';
                    // document.getElementById('username').nodeValue.slice(0, -1);
                    // document.getElementById('firstName').nodeValue += ' ';
                    // document.getElementById('firstName').nodeValue.slice(0, -1);
                    // document.getElementById('lastName').nodeValue += ' ';
                    // document.getElementById('lastName').nodeValue.slice(0, -1);
                    // document.getElementById('country').nodeValue += ' ';
                    // document.getElementById('country').nodeValue.slice(0, -1);
                    // document.getElementById('city').nodeValue += ' ';
                    // document.getElementById('city').nodeValue.slice(0, -1);
                }
            );
        }
    }

    /**
     * Initialize the component with fake data
     */
    private initFakeData() {
        this.user = {
            id: 1,
            username: 'bob123',
            email: 'booby@mail.com',
            firstName: 'Bob',
            lastName: 'Smith',
            birthDate: '1994-09-22',  //'9/22/1994'
            gender: 'MALE',
            level: 'BEGINNER',
            country: 'USA',
            city: 'Los Angeles',
            photo: null,
            role: 'MUSHROOMER'
        };
    }

    /**
     * Reader loaded handle
     * @param event     Event
     */
    handleReaderLoaded(event: any) {
        var reader = event.target;
        this.imageSrc = reader.result;
    }

    /**
     * Input change handle
     * @param event     Event
     */
    handleInputChange(event: any) {
        var file = event.dataTransfer ? event.dataTransfer.files[0] : event.target.files[0];
        var pattern = /image-*/;
        var reader = new FileReader();
        if (!file.type.match(pattern)) {
            alert('invalid format');
            return;
        }
        reader.onload = this.handleReaderLoaded.bind(this);
        reader.readAsDataURL(file);
        this.userService.updateImage(file).subscribe(
            data => {
                this.user.photo = file;
                this.ngOnInit();
                this.snackBar.open('Photo Saved', '×', {
                    duration: 2000,
                });
            },
            error => {
                this.loading = false;
                this.user.photo = null;
                this.snackBar.open('Error', '×', {
                    duration: 2000,
                });
            });
    }

    /**
     * Update button handle
     */
    update() {
        this.inputDate.setHours(this.inputDate.getHours() + 2);
        this.user.birthDate = this.inputDate.toISOString().slice(0, -1);
        this.loading = true;
        this.userService.update(this.user)
            .subscribe(
                result => {
                    this.ngOnInit();
                    this.snackBar.open('User Updated', '×', {
                        duration: 2000,
                    });
                    this.user = result;
                },
                error => {
                    this.loading = false;
                    this.snackBar.open('Error', '×', {
                        duration: 2000,
                    });
                });
    }
}
