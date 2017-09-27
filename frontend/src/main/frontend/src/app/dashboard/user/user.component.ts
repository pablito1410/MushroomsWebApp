import { Component, OnInit, Inject } from '@angular/core';
import { UserService } from "../../services/user.service";
import { MdSnackBar } from "@angular/material";
import { DOCUMENT } from "@angular/platform-browser";
import { User } from "../../model/user";
import { PhotoTool } from "../../tools/photo-tool";

@Component({
    moduleId: module.id,
    selector: 'user-cmp',
    templateUrl: 'user.component.html'
})
export class UserComponent implements OnInit {
    user: User;
    loading = false;
    imageSrc: string;
    file: File;
    inputDate: Date;

    /** Static method assignment */
    getPhotoStringToDisplay = PhotoTool.getPhotoStringToDisplay;

    constructor(
        private userService: UserService,
        public snackBar: MdSnackBar,
        @Inject(DOCUMENT) private document) {
        this.user = new User();
        this.inputDate = new Date();
    }

    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
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
        } else {
            this.userService.get().subscribe(
                result => {
                    this.user = result;
                    if (this.user.birthDate != null && this.user.birthDate != '')
                        this.inputDate = new Date(this.user.birthDate);
                    document.getElementById('email').nodeValue += ' ';
                    document.getElementById('email').nodeValue.slice(0, -1);
                    document.getElementById('username').nodeValue += ' ';
                    document.getElementById('username').nodeValue.slice(0, -1);
                    document.getElementById('firstName').nodeValue += ' ';
                    document.getElementById('firstName').nodeValue.slice(0, -1);
                    document.getElementById('lastName').nodeValue += ' ';
                    document.getElementById('lastName').nodeValue.slice(0, -1);
                    document.getElementById('country').nodeValue += ' ';
                    document.getElementById('country').nodeValue.slice(0, -1);
                    document.getElementById('city').nodeValue += ' ';
                    document.getElementById('city').nodeValue.slice(0, -1);
                }
            );
        }
        console.log(this.user.birthDate);
    }

    handleReaderLoaded(e) {
        var reader = e.target;
        this.imageSrc = reader.result;
    }

    handleInputChange(event) {
        var file = event.dataTransfer ? event.dataTransfer.files[0] : event.target.files[0];
        var pattern = /image-*/;
        var reader = new FileReader();
        if (!file.type.match(pattern)) {
            alert('invalid format');
            return;
        }
        console.log(file);
        reader.onload = this.handleReaderLoaded.bind(this);
        reader.readAsDataURL(file);
        console.log(file);
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
