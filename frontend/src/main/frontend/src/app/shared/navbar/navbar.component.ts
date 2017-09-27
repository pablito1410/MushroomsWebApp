import { Component, Inject, OnInit } from '@angular/core';
import { ROUTES } from '../.././sidebar/sidebar-routes.config';
import { MenuType } from '../.././sidebar/sidebar.metadata';
import { Location, LocationStrategy, PathLocationStrategy } from '@angular/common';
import { AuthenticationService } from "../../services/authentication.service";
import { NotificationService } from "../../services/notification.service";
import { Notification } from "../../model/notification";
import { MdSnackBar } from "@angular/material";
import { DOCUMENT } from "@angular/platform-browser";

/**
 * Navbar component
 */
@Component({
    moduleId: module.id,
    selector: 'navbar-cmp',
    templateUrl: 'navbar.component.html'
})
export class NavbarComponent implements OnInit {

    /** Array with notifications */
    notifications: Notification[];
    /** Array route titles */
    private arrayTitles: any[];
    /** Router location */
    location: Location;

    /**
     * Constructor of class
     * @param location                  Router location
     * @param document                  Current document
     * @param authenticationService     Authentication service
     * @param notificationService       Notification service
     */
    constructor(
        location: Location,
        @Inject(DOCUMENT) private document,
        private authenticationService: AuthenticationService,
        private notificationService: NotificationService) {
        this.notifications = new Array<Notification>();
        this.location = location;
    }

    /**
     * Initialization method
     */
    ngOnInit() {
        this.arrayTitles = ROUTES.filter(listTitle => listTitle.menuType !== MenuType.BRAND);
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this.initFakeData();
        } else {
            this.notificationService.getAll().subscribe(
                result => this.notifications = result
            );
        }
    }

    /**
     * Initialize the component with fake data
     */
    private initFakeData() {
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
    }

    /**
     * Logout button handle
     */
    logout() {
        this.authenticationService.logout();
    }

    /**
     * Gets route title
     * @returns     Route title
     */
    getTitle(): string {
        var title = this.location.prepareExternalUrl(this.location.path());
        if (title.charAt(0) === '#') {
            title = title.slice( 2 );
        }
        for (var item = 0; item < this.arrayTitles.length; item++) {
            if (this.arrayTitles[item].path === title) {
                return this.arrayTitles[item].title;
            }
        }
        return 'Dashboard';
    }

    /**
     * Check if there are any notifications
     */
    checkNotifications(): boolean {
        return this.notifications.length > 0
    }
}
