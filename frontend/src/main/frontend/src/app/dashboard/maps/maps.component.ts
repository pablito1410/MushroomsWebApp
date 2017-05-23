import { Component, OnInit } from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'maps-cmp',
    templateUrl: 'maps.component.html'
})
export class MapsComponent implements OnInit {

    zoom: number = 8;
    lat: number = 50.287977;
    lng: number = 18.677049;
    markers: Marker[];

    ngOnInit() {
        this.markers = [
            {
                lat: 51.673858,
                lng: 7.815982,
                label: 'A',
                draggable: true
            },
            {
                lat: 51.373858,
                lng: 7.215982,
                label: 'B',
                draggable: false
            },
            {
                lat: 51.723858,
                lng: 7.895982,
                label: 'C',
                draggable: true
            }
        ];
    }

    clickedMarker(label: string, index: number) {
        console.log(`clicked the marker: ${label || index}`);
    }

    mapClicked($event: any) {
        this.markers.push({
            lat: $event.coords.lat,
            lng: $event.coords.lng,
            label: null,
            draggable: null
        });
    }

    markerDragEnd(m: Marker, $event: MouseEvent) {
        console.log('dragEnd', m, $event);
    }
}
