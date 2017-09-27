import { Component, Inject, OnInit } from '@angular/core';
import { DOCUMENT } from "@angular/platform-browser";
import { NotificationService } from "app/services/notification.service";
import { TripService } from "app/services/trip.service";
import { UserService } from "app/services/user.service";
import { DiscoveryService } from "app/services/discovery.service";
import { Notification } from "app/model/notification";
import { MdSnackBar, MdDialog } from "@angular/material";
import { UserDetailsComponent } from "app/dashboard/user/user-details/user-details.component";
import { DiscoveryDetailsComponent } from "app/dashboard/discoveries/discovery-details/discovery-details.component";
import { TripDetailsComponent } from "app/dashboard/trips/trip-details/trip-details.component";

/**
 * Notifications page component
 */
@Component({
    moduleId: module.id,
    selector: 'notifications-cmp',
    templateUrl: 'notifications.component.html'
})
export class NotificationsComponent implements OnInit {

    /** Array with model notification objects */
    notifications: Notification[];
    /** Option selected in dialog */
    selectedOption: string;

    /**
     * Constructor of class
     * @param dialog                    Material dialog
     * @param notificationService       Notification service
     * @param tripService               Trip service
     * @param userService               User service
     * @param discoveryService          Discovery service
     * @param document                  Current document
     * @param snackBar                  Material snack bar
     */
    constructor(
        public dialog: MdDialog,
        private notificationService: NotificationService,
        private tripService: TripService,
        private userService: UserService,
        private discoveryService: DiscoveryService,
        @Inject(DOCUMENT) private document,
        public snackBar: MdSnackBar) { }

    /**
     * Initialization method
     */
    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this. initFakeData();
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
     * Gets type of icon to display based on type of notification
     * @param type      Type of notification
     * @returns         Type of icon
     */
    getIconType(type: string): string {
        switch (type) {
            case 'FRIEND_INVITATION':
            case 'FRIEND_ACCEPTING':
                return 'person';
            case 'TRIP_ADDING':
            case 'TRIP_ACCEPTING':
                return 'directions_walk';
            case 'MUSHROOM_FINDING':
            case 'DISCOVERY_ADD_SCORE':
                return 'add_alert';
            default:
                return 'add_alert';
        }
    }

    /**
     * Delete notification button handle
     * @param id    Notification identification number
     */
    deleteNotification(id: number) {
        this.notificationService.delete(id).subscribe(
            response => {
                this.ngOnInit();
                this.snackBar.open('Delete Success', '×', {
                    duration: 2000,
                });
            },
            error => {
                this.snackBar.open('Delete Error', '×', {
                    duration: 2000,
                });
            }
        );
    }

    /**
     * Opens appropriate dialog window
     * @param relatedId     Identification number of related model object
     * @param type          Type of notification
     * @param id            Identification number of notification
     */
    openDialog(relatedId: number, type: string, id: number) {
        switch (type) {
            case 'FRIEND_INVITATION':
                this.userService.getById(relatedId).subscribe(
                    result => this.openFriendDetailsDialog(result, 'requests', id)
                );
                break;
            case 'FRIEND_ACCEPTING':
                this.userService.getById(relatedId).subscribe(
                    result => this.openFriendDetailsDialog(result, 'details', id)
                );
                break;
            case 'TRIP_ADDING':
                this.tripService.getById(relatedId).subscribe(
                    result => this.openTripDetailsDialog(result, 'requests', id)
                );
                break;
            case 'TRIP_ACCEPTING':
                this.tripService.getById(relatedId).subscribe(
                    result => this.openTripDetailsDialog(result, 'details', id)
                );
                break;
            case 'MUSHROOM_FINDING':
            case 'DISCOVERY_ADD_SCORE':
                this.discoveryService.getById(relatedId).subscribe(
                    result => this.openDiscoveryDetailsDialog(result, 'details', id)
                );
                break;
        }
    }

    /**
     * Open friend details dialog
     * @param user      User
     * @param status    Status
     * @param id        Identification number of notification
     */
    openFriendDetailsDialog(user: any, status: string, id: number) {
        let dialogRef = this.dialog.open(UserDetailsComponent, {
            data: { 
                user: user,
                status: status
            },
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
            if (this.selectedOption == 'Accepted')
                this.deleteNotification(id);
        });
    }

    /**
     * Open discovery details dialog
     * @param discovery     Discovery
     * @param status        Status
     * @param id            Identification number of notification
     */
    openDiscoveryDetailsDialog(discovery: any, status: string, id: number) {
        let dialogRef = this.dialog.open(DiscoveryDetailsComponent, {
            data: {
                discovery: discovery,
                status: status
            },
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
            if (this.selectedOption == 'Accepted')
                this.deleteNotification(id);
        });
    }

    /**
     * Open trip details dialog
     * @param trip      Trip
     * @param status    Status
     * @param id        Identification number of notification
     */
    openTripDetailsDialog(trip: any, status: string, id: number) {
        let dialogRef = this.dialog.open(TripDetailsComponent, {
            data: { 
                trip: trip,
                status: status
            },
            hasBackdrop: true,
            height: '80%',
            width: '80%',
        });
        dialogRef.afterClosed().subscribe(result => {
            this.selectedOption = result;
            if (this.selectedOption == 'Accepted')
                this.deleteNotification(id);
        });
    }
}
