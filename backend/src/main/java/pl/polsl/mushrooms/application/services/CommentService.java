package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.comment.CreateCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.DeleteCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.UpdateCommentCommand;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public interface CommentService {

    /**
     * Creates a comment to the discovery
     * @param command
     * @return Id of created comment
     */
    long handle(CreateCommentCommand command);

    /**
     * Updates the comment
     * @param command
     */
    void handle(UpdateCommentCommand command);

    /**
     * Deletes the comment
     * @param command
     */
    void handle(DeleteCommentCommand command);
}
