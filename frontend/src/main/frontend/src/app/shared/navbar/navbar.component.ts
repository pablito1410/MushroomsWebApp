import {Component, Inject, OnInit} from '@angular/core';
import { ROUTES } from '../.././sidebar/sidebar-routes.config';
import { MenuType } from '../.././sidebar/sidebar.metadata';
import {Location, LocationStrategy, PathLocationStrategy} from '@angular/common';
import {AuthenticationService} from "../../services/authentication.service";
import {NotificationService} from "../../services/notification.service";
import {Notification} from "../../model/notification";
import {MdSnackBar} from "@angular/material";
import {DOCUMENT} from "@angular/platform-browser";

@Component({
    moduleId: module.id,
    selector: 'navbar-cmp',
    templateUrl: 'navbar.component.html'
})

export class NavbarComponent implements OnInit {

    notifications: Notification[];

    private listTitles: any[];

    location: Location;

    constructor(
        location: Location,
        @Inject(DOCUMENT) private document,
        private authenticationService: AuthenticationService,
        private notificationService: NotificationService) {
        this.location = location;
    }

    ngOnInit() {
        this.listTitles = ROUTES.filter(listTitle => listTitle.menuType !== MenuType.BRAND);
        if (+document.location.port == 4200) {
            this.notifications = [
                {
                    id: 1,
                    content: 'Marian would like to add you to your friends',
                    type: 'FRIEND_INVITATION',
                    relatedId: 2,
                    dateTime: '2016-06-21T19:09:42.646Z'
                },
                {
                    id: 2,
                    content: 'Kasia invited you on a trip',
                    type: 'TRIP_ADDING',
                    relatedId: 2,
                    dateTime: '2016-06-21T19:09:42.646Z'
                },
                {
                    id: 3,
                    content: 'Michael found the mushroom on a trip in Krakow',
                    type: 'MUSHROOM_FINDING',
                    relatedId: 2,
                    dateTime: '2016-06-21T19:09:42.646Z'
                }
            ];
        } else {
            this.notificationService.getAll().subscribe(
                result => this.notifications = result
            );
        }
    }

    logout() {
        this.authenticationService.logout();
    }

    getTitle() {
        var title = this.location.prepareExternalUrl(this.location.path());
        if(title.charAt(0) === '#'){
            title = title.slice( 2 );
        }
        for(var item = 0; item < this.listTitles.length; item++){
            if(this.listTitles[item].path === title){
                return this.listTitles[item].title;
            }
        }
        return 'Dashboard';
    }
}
