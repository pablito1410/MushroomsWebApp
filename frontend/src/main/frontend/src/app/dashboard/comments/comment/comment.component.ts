import {Component, OnInit, Input} from '@angular/core';
import {Discovery} from "../../../model/discovery";
import { MdDialog} from "@angular/material";
import {SearchFriendsComponent} from "../../friends/search-friends/search-friends.component";
import {DiscoveryService} from "../../../services/discovery.service";
import {Comment} from "../../../model/comment";
import LinkedList from "ng2-bootstrap/utils/linked-list.class";
import {CommentService} from "../../../services/comment.service";
import {CreateCommentCommand} from "../../../commands/create-comment.command";
import {MdSnackBar} from "@angular/material";

@Component({
    moduleId: module.id,
    selector: 'comment-cmp',
    templateUrl: 'comment.component.html'
})
export class CommentComponent implements OnInit {
    @Input() comment: Comment;
    expanded: boolean;
    textBox: boolean;
    commentContent: string;

    constructor(
        public snackBar: MdSnackBar,
        private commentService: CommentService) {
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

    getUserPhotoToDisplay() : string {
        return 'data:image/png;base64,' + this.comment.user.photo;
    }
}