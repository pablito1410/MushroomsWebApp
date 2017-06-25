import {Component, OnInit, Inject} from '@angular/core';
import { UserService } from "../../services/user.service";
import { Router } from "@angular/router";
import { MdSnackBar } from "@angular/material";

@Component({
    moduleId: module.id,
    selector: 'user-cmp',
    templateUrl: 'user.component.html'
})
export class UserComponent implements OnInit {
    model: any = {};
    loading = false;
    imageSrc: string;
    file: File;
    photo: any;
    genders = [
        {value: 'MALE', viewValue: 'Male'},
        {value: 'FEMALE', viewValue: 'Female'}
    ];

    constructor(
        private router: Router,
        private userService: UserService,
        public snackBar: MdSnackBar) { }

    ngOnInit() {
        this.userService.get().subscribe(
            value => this.model = value
        );
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
                this.model = data;
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
        this.userService.update(this.model)
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
