import {Component, OnInit, Inject} from '@angular/core';
import { UserService } from "../../services/user.service";
import { Router } from "@angular/router";

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
        private userService: UserService) { }

    ngOnInit() {
        let currentUser = localStorage.getItem('currentUser');
        if (currentUser) {
            this.model = JSON.parse(currentUser);
        }
    }

    handleReaderLoaded(e) {
        var reader = e.target;
        this.imageSrc = reader.result;
    }

    handleInputChange(e) {
        var file = e.dataTransfer ? e.dataTransfer.files[0] : e.target.files[0];

        var pattern = /image-*/;
        var reader = new FileReader();

        if (!file.type.match(pattern)) {
            alert('invalid format');
            return;
        }

        reader.onload = this.handleReaderLoaded.bind(this);
        reader.readAsDataURL(file);
    }

    update() {
        this.loading = true;
        this.userService.update(this.model)
            .subscribe(
                data => {
                    // this.alertService.success('Registration successful', true);
                    this.router.navigate(['/user']);
                },
                error => {
                    // this.alertService.error(error);
                    this.loading = false;
                });
    }
}
