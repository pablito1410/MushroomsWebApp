import {Component, OnInit, Inject} from "@angular/core";
import {MdDialogRef, MdSnackBar, MD_DIALOG_DATA} from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";
import {Comment} from "../../../model/comment";
import {Score} from "../../../model/score";

@Component({
    moduleId: module.id,
    selector: 'discovery-details-cmp',
    templateUrl: 'discovery-details.component.html'
})
export class DiscoveryDetailsComponent implements OnInit {
    // discovery: any;
    comments: Array<Comment>;
    score: Score;
    starsCount: number;
    showRating: boolean;

    constructor(
        public dialogRef: MdDialogRef<DiscoveryDetailsComponent>,
        @Inject(MD_DIALOG_DATA) public discovery: any,
        public snackBar: MdSnackBar) {
        this.showRating = true;
    }

    ngOnInit() {
        // this.discovery = {
        //     id: 1,
        //     name: 'Podgrzybek',
        //     coordinateX: 51.673858,
        //     coordinateY: 7.815982,
        //     photo: null,
        //     date: '12.05.2017 9:44'
        // };
        let comment111 = new Comment("Item 1.1.1", []);
        let comment112 = new Comment("Item 1.1.2", []);
        let comment113 = new Comment("Item 1.1.3", []);
        let comment11 = new Comment("Item 1.1", [comment111, comment112, comment113]);
        let comment121 = new Comment("Item 1.2.1", []);
        let comment122 = new Comment("Item 1.2.2", []);
        let comment123 = new Comment("Item 1.2.3", []);
        let comment12 = new Comment("Item 1.2", [comment121, comment122, comment123]);
        let comment131 = new Comment("Item 1.3.1", []);
        let comment132 = new Comment("Item 1.3.2", []);
        let comment133 = new Comment("Item 1.3.3", []);
        let comment13 = new Comment("Item 1.3", [comment131, comment132, comment133]);
        let comment1 = new Comment("Item 1", [comment11, comment12, comment13]);
        let comment211 = new Comment("Item 1.1.1", []);
        let comment212 = new Comment("Item 2.1.2", []);
        let comment213 = new Comment("Item 2.1.3", []);
        let comment21 = new Comment("Item 2.1", [comment211, comment212, comment213]);
        let comment221 = new Comment("Item 2.2.1", []);
        let comment222 = new Comment("Item 2.2.2", []);
        let comment223 = new Comment("Item 2.2.3", []);
        let comment22 = new Comment("Item 2.2", [comment221, comment222, comment223]);
        let comment231 = new Comment("Item 2.3.1", []);
        let comment232 = new Comment("Item 2.3.2", []);
        let comment233 = new Comment("Item 2.3.3", []);
        let comment23 = new Comment("Item 2.3", [comment231, comment232, comment233]);
        let comment2 = new Comment("Item 2", [comment21, comment22, comment23]);
        this.comments = [comment1, comment2];
        this.discovery.tags = [
            {
                id: 1,
                name: 'grzyb',
                discoveryId: 1
            },
            {
                id: 2,
                name: 'las',
                discoveryId: 1
            },
            {
                id: 3,
                name: 'gliwice',
                discoveryId: 1
            },
            {
                id: 4,
                name: 'pogrzybek',
                discoveryId: 1
            }
        ];
    }

    rate() {
        this.showRating = false;
        this.snackBar.open('Discovery Has Rated ', '×', {
            duration: 2000,
        });
    }

    comment() {

    }
}