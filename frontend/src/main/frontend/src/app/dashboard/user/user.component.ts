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
    imageSrc: string = '';

    constructor(
        private router: Router,
        private userService: UserService,
        public snackBar: MdSnackBar) { }

    ngOnInit() {
        this.userService.get().subscribe(
            value => this.model = value
        );
    }

    private openSnackBar(message: string, action: string) {
        this.snackBar.open(message, action, {
            duration: 2000,
        });
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
                this.openSnackBar('Photo Saved', '×');
            },
            error => {
                this.loading = false;
                this.openSnackBar('Change Profile Photo Error', '×');
            });
    }

    update() {
        this.loading = true;
        this.userService.update(this.model)
            .subscribe(
                data => {
                    this.router.navigate(['/users']);
                    this.openSnackBar('Profile Uploaded', '×');
                },
                error => {
                    this.loading = false;
                    this.openSnackBar('Update Error', '×');
                });
    }
}
