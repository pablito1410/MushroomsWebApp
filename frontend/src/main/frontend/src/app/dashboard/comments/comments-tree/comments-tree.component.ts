import {Component, OnInit, Input} from '@angular/core';
import {Discovery} from "../../../model/discovery";
import { MdDialog} from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";
import {DiscoveryService} from "../../../services/discovery.service";
import {Comment} from "../../../model/comment";
import LinkedList from "ng2-bootstrap/utils/linked-list.class";

@Component({
    moduleId: module.id,
    selector: 'comments-tree-cmp',
    templateUrl: 'comments-tree.component.html'
})
export class CommentsTreeComponent implements OnInit {
    @Input() comments: Array<Comment>;

    constructor() { }

    ngOnInit() {

    }

}