import {Component, OnInit, Inject} from '@angular/core';
import { UserService } from "../../services/user.service";
import { Router } from "@angular/router";
import { MdSnackBar } from "@angular/material";
import {DOCUMENT} from "@angular/platform-browser";
import {User} from "../../model/user";

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
    genders = [
        {value: 'MALE', viewValue: 'Male'},
        {value: 'FEMALE', viewValue: 'Female'}
    ];

    constructor(
        private router: Router,
        private userService: UserService,
        public snackBar: MdSnackBar,
        @Inject(DOCUMENT) private document) { }

    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this.user = {
                id: 1,
                username: 'bob123',
                email: 'booby@mail.com',
                firstName: 'Bob',
                lastName: 'Smith',
                birthDate: '2016-06-27',
                gender: 'MALE',
                level: 'BEGINNER',
                country: 'USA',
                city: 'Los Angeles',
                photo: null,
                role: 'MUSHROOMER'
            };
        } else {
            this.user = new User();
            this.userService.get().subscribe(
                result => this.user = result
            );
        }
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
                this.router.navigate(['/users']);
                this.snackBar.open('Photo Saved', '×', {
                    duration: 2000,
                });
                this.user.photo = file;

            },
            error => {
                this.loading = false;
                this.snackBar.open('Error', '×', {
                    duration: 2000,
                });
            });
    }

    update() {
        let birthDate = new Date(this.user.birthDate);
        // birthDate.setHours(birthDate.getHours() + 2);
        this.user.birthDate = birthDate.toISOString();
        this.loading = true;
        this.userService.update(this.user)
            .subscribe(
                result => {
                    this.router.navigate(['/users']);
                    this.snackBar.open('Photo Saved', '×', {
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
