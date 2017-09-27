import { Component, OnInit, Input } from '@angular/core';
import { Discovery } from "../../../model/discovery";
import { MdDialog } from "@angular/material";
import { SearchFriendsComponent } from "../../friends/search-friends/search-friends.component";
import { DiscoveryService } from "../../../services/discovery.service";
import { Comment } from "../../../model/comment";

/**
 * Comments tree component
 */
@Component({
    moduleId: module.id,
    selector: 'comments-tree-cmp',
    templateUrl: 'comments-tree.component.html'
})
export class CommentsTreeComponent implements OnInit {

    /** Input array of model comment objects */
    @Input() comments: Array<Comment>;

    /**
     * Constructor of class
     */
    constructor() {
        // for future use
    }

    /**
     * Initialization method
     */
    ngOnInit() {
        // for future use
    }
}