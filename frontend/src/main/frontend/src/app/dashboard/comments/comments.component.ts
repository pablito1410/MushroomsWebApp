import {Component, OnInit, Input} from '@angular/core';
import {Discovery} from "../../model/discovery";
import { MdDialog} from "@angular/material";
import {SearchFriendsComponent} from "../friends/search-friends/search-friends.component";
import {DiscoveryService} from "../../services/discovery.service";
import {Comment} from "../../model/comment";
import LinkedList from "ng2-bootstrap/utils/linked-list.class";

@Component({
    moduleId: module.id,
    selector: 'comments-cmp',
    templateUrl: 'comments.component.html'
})
export class CommentsComponent implements OnInit {
    @Input() comments: Array<Comment>;

    constructor() { }

    ngOnInit() {
        // this.comments.value = null;
        // let current = this.comments;
        //
        // this.comments.subtree.push(
        //     new Tree<Comment>(),
        //     new Tree<Comment>(),
        //     new Tree<Comment>(),
        //     new Tree<Comment>()
        // );
    }



}