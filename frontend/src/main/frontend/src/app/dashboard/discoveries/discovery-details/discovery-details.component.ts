import {Component, OnInit, Inject} from "@angular/core";
import {MdDialogRef, MdSnackBar, MD_DIALOG_DATA} from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";
import {Comment} from "../../../model/comment";
import {Score} from "../../../model/score";
import {DOCUMENT} from "@angular/platform-browser";
import {DiscoveryService} from "../../../services/discovery.service";
import {Tag} from "app/model/tag";
import {Discovery} from "app/model/discovery";
import {AddScoreCommand} from "app/commands/add-score.command";
import {ScoreService} from "../../../services/score.service";

@Component({
    moduleId: module.id,
    selector: 'discovery-details-cmp',
    templateUrl: 'discovery-details.component.html'
})
export class DiscoveryDetailsComponent implements OnInit {
    comments: Comment[];
    tags: Tag[];
    score: Score;
    starsCount: number;
    showRating: boolean;
    zoom: number = 4;

    constructor(
        public dialogRef: MdDialogRef<DiscoveryDetailsComponent>,
        @Inject(MD_DIALOG_DATA) public data: any,
        @Inject(DOCUMENT) private document,
        public snackBar: MdSnackBar,
        private discoveryService: DiscoveryService,
        private scoreService: ScoreService) {
        this.comments = new Array<Comment>();
        this.tags = new Array<Tag>();
        this.score = new Score();
    }

    ngOnInit() {
        if (+document.location.port == 4200) {
            // for only frontend development purposes
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
            this.tags = [
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
        } else {
            this.discoveryService.comments(this.data.discovery.id).subscribe(
                result => this.comments = result
            );
            this.discoveryService.tags(this.data.discovery.id).subscribe(
                result => this.tags = result
            );
            
            // this.scoreService.getAverage().subscribe(
            //     result => this.score = result
            // );
        }
        this.showRating = true;
    }

    rate() {
        console.log(this.starsCount);
        this.scoreService.add(new AddScoreCommand(this.data.discovery.id, this.starsCount)).subscribe(
            data => {
                this.ngOnInit();
                this.showRating = false;
                this.snackBar.open('Discovery Added', '×', {
                    duration: 2000,
                });
            },
            error => {
                this.snackBar.open('Error', '×', {
                    duration: 2000,
                });
            });
    }

    comment() {
        
    }

    getPhotoToDisplay(photo: any) : string {
        return 'data:image/png;base64,' + photo;
    }

}