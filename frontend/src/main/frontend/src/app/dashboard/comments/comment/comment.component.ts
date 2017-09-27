import { Component, OnInit, Input } from '@angular/core';
import { Discovery } from "../../../model/discovery";
import { MdDialog} from "@angular/material";
import { SearchFriendsComponent } from "../../friends/search-friends/search-friends.component";
import { DiscoveryService } from "../../../services/discovery.service";
import { Comment } from "../../../model/comment";
import { CommentService } from "../../../services/comment.service";
import { CreateCommentCommand } from "../../../commands/create-comment.command";
import { MdSnackBar } from "@angular/material";
import { Tools } from "../../../tools/tools";

/**
 * Single comment component
 */
@Component({
    moduleId: module.id,
    selector: 'comment-cmp',
    templateUrl: 'comment.component.html'
})
export class CommentComponent implements OnInit {

    /** Input model comment object */
    @Input() comment: Comment;
    /** Flag indicating whether the comment is expanded */
    expanded: boolean;
    /** Flag indicating whether the text box is displayed */
    textBox: boolean;
    /** Content of comment from text box */
    commentContent: string;

    /** Static method get photo string to display assignment */
    getPhotoStringToDisplay = Tools.getPhotoStringToDisplay;

    /**
     * Constructor of class
     * @param snackBar          Material snack bar
     * @param commentService    Comment service
     */
    constructor(
        public snackBar: MdSnackBar,
        private commentService: CommentService) {
        this.expanded = false;
        this.textBox = false;
    }

    /**
     * Initialization method
     */
    ngOnInit() {
        // for future use
    }

    /**
     * Hide / show answers button handle
     */
    toggle() {
        this.expanded = !this.expanded;
        this.textBox = false;
    }

    /**
     * Reply button handle
     */
    write() {
        this.textBox = true;
        this.expanded = true;
    }

    /**
     * Cancel button handle
     */
    cancel() {
        this.textBox = false;
    }

    /**
     * Submit button handle
     */
    submit() {
        this.commentService.create(
            new CreateCommentCommand(
                this.comment.id, null, this.commentContent, new Date().toISOString().slice(0, -1)))
                .subscribe(
                    data => {
                        this.textBox = false;
                        this.snackBar.open('Comment Added', '×', {
                            duration: 2000,
                        });
                    },
                    error => {
                        this.snackBar.open('Error', '×', {
                            duration: 2000,
                        });
                    }
                );
    }
}