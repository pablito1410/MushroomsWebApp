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
                birthDate: '22.05.1987',
                gender: 'MALE',
                level: 'BEGINNER',
                country: 'USA',
                city: 'Los Angeles',
                photo: null
            };
        } else {
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
                this.user = data;
                this.router.navigate(['/users']);
                this.snackBar.open('Photo Saved', '×', {
                    duration: 2000,
                });

            },
            error => {
                this.loading = false;
                this.snackBar.open('Error', '×', {
                    duration: 2000,
                });
            });
    }

    update() {
        this.loading = true;
        this.userService.update(this.user)
            .subscribe(
                data => {
                    this.router.navigate(['/users']);
                    this.snackBar.open('Photo Saved', '×', {
                        duration: 2000,
                    });
                },
                error => {
                    this.loading = false;
                    this.snackBar.open('Error', '×', {
                        duration: 2000,
                    });
                });
    }
}
