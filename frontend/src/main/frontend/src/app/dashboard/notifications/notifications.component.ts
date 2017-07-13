import {Component, Inject, OnInit} from '@angular/core';
import {DOCUMENT} from "@angular/platform-browser";
import {NotificationService} from "app/services/notification.service";
import {Notification} from "app/model/notification";
import {MdSnackBar} from "@angular/material";

@Component({
    moduleId: module.id,
    selector: 'notifications-cmp',
    templateUrl: 'notifications.component.html'
})

export class NotificationsComponent implements OnInit {

    notifications: Notification[];

    constructor(
        private notificationService: NotificationService,
        @Inject(DOCUMENT) private document,
        public snackBar: MdSnackBar) { }

    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this.notifications = [
                {
                    id: 1,
                    content: 'Marian would like to add you to your friends',
                    type: 'FRIEND INVITATION',
                    relatedId: 2,
                    dateTime: '2016-06-21T19:09:42.646Z'
                },
                {
                    id: 2,
                    content: 'Kasia invited you on a trip',
                    type: 'TRIP ADDING',
                    relatedId: 2,
                    dateTime: '2016-06-21T19:09:42.646Z'
                },
                {
                    id: 3,
                    content: 'Michael found the mushroom on a trip in Krakow',
                    type: 'MUSHROOM FINDING',
                    relatedId: 2,
                    dateTime: '2016-06-21T19:09:42.646Z'
                }
            ]
        } else {
            this.notificationService.getAll().subscribe(
                result => this.notifications = result
            );
        }
    }

    getIconType(type: String) : String {
        switch (type) {
            case 'FRIEND_INVITATION':
            case 'FRIEND_ACCEPTING':
                return 'person';
            case 'TRIP_ADDING':
            case 'TRIP_ADDING':
                return 'directions_walk';
            case 'MUSHROOM_FINDING':
            case 'DISCOVERY_ADD_SCORE':
                return 'add_alert';
            default:
                return 'add_alert';
        }
    }

    deleteNotification(id: number, index: number) {
        this.notificationService.delete(id).subscribe(
            response => {
                this.notifications.splice(index, 1);
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
}
