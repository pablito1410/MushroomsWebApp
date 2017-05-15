package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.comment.CreateCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.DeleteCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.UpdateCommentCommand;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public interface CommentService {

    UUID handle(CreateCommentCommand command);

    void handle(UpdateCommentCommand command);

    void handle(DeleteCommentCommand command);
}
