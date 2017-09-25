import {Component, OnInit, Input} from '@angular/core';
import {Discovery} from "../../../model/discovery";
import { MdDialog} from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";
import {DiscoveryService} from "../../../services/discovery.service";
import {Comment} from "../../../model/comment";
import LinkedList from "ng2-bootstrap/utils/linked-list.class";

@Component({
    moduleId: module.id,
    selector: 'comment-cmp',
    templateUrl: 'comment.component.html'
})
export class CommentComponent implements OnInit {
    @Input() comment: Comment;
    expanded: boolean;
    textBox: boolean;

    constructor() {
        this.expanded = false;
        this.textBox = false;
    }

    ngOnInit() {

    }

    toggle() {
        this.expanded = !this.expanded;
        this.textBox = false;
    }

    write() {
        this.textBox = true;
        this.expanded = true;
    }

    cancel() {
        this.textBox = false;
    }

    submit() {
        this.textBox = false;
    }

    getUserPhotoToDisplay() : string {
        return 'data:image/png;base64,' + this.comment.user.photo;
    }
}