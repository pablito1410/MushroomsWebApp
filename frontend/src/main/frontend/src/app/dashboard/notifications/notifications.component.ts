import {Component, OnInit} from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'notifications-cmp',
    templateUrl: 'notifications.component.html'
})

export class NotificationsComponent implements OnInit {
    notifications: any[];
    constructor() {}
    ngOnInit() {
        this.notifications = [
            { icon : 'person', message : 'Marian would like to add you to your friends' },
            { icon : 'add_alert', message : 'Kasia invited you on a trip' },
            { icon : 'directions_walk', message : 'Michael found the mushroom on a trip in Krakow' }
        ]
    }

    deleteNotification(index: number) {
        this.notifications.splice(index, 1);
    }
}
