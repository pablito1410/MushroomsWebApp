import {Component, Inject, OnInit} from '@angular/core';
import {DOCUMENT} from "@angular/platform-browser";

@Component({
    moduleId: module.id,
    selector: 'notifications-cmp',
    templateUrl: 'notifications.component.html'
})

export class NotificationsComponent implements OnInit {
    notifications: any[];

    constructor(@Inject(DOCUMENT) private document) { }

    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
            this.notifications = [
                {icon: 'person', message: 'Marian would like to add you to your friends'},
                {icon: 'add_alert', message: 'Kasia invited you on a trip'},
                {icon: 'directions_walk', message: 'Michael found the mushroom on a trip in Krakow'}
            ]
        } else {
            // TODO
        }
    }

    deleteNotification(index: number) {
        this.notifications.splice(index, 1);
    }
}
