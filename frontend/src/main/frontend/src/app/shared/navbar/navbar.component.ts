import { Component, Inject, OnInit, OnChanges } from '@angular/core';
import { ROUTES } from '../.././sidebar/sidebar-routes.config';
import { MenuType } from '../.././sidebar/sidebar.metadata';
import { Location, LocationStrategy, PathLocationStrategy } from '@angular/common';
import { AuthenticationService } from "../../services/authentication.service";
import { NotificationService } from "../../services/notification.service";
import { UserService } from "../../services/user.service";
import { Notification } from "../../model/notification";
import { User } from "../../model/user";
import { MdSnackBar } from "@angular/material";
import { DOCUMENT } from "@angular/platform-browser";
import { Tools } from "../../tools/tools";
import { Observable } from 'rxjs/Rx';

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
    /** Current user */
    user: User;

    /** Static method get photo string to display assignment */
    getPhotoStringToDisplay = Tools.getPhotoStringToDisplay;

    /**
     * Constructor of class
     * @param location                  Router location
     * @param document                  Current document
     * @param authenticationService     Authentication service
     * @param notificationService       Notification service
     * @param userService               User service
     */
    constructor(
        location: Location,
        @Inject(DOCUMENT) private document,
        private authenticationService: AuthenticationService,
        private notificationService: NotificationService,
        private userService: UserService) {
        this.notifications = new Array<Notification>();
        this.location = location;
        this.user = new User();
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
            this.getData();
            // refresh any minute
            Observable.interval(1000 * 60).subscribe(x => {
                this.getData();
            });
        }
    }

    /**
     * Gets data from server
     */
    getData() {
        this.userService.get().subscribe(
            result => this.user = result
        );
        this.notificationService.getAll().subscribe(
            result => this.notifications = result
        );
    }

    /**
     * Initialize the component with fake data
     */
    private initFakeData() {
        this.user.username = "mati";
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
