package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.comment.CreateCommand;
import pl.polsl.mushrooms.application.commands.comment.DeleteCommand;
import pl.polsl.mushrooms.application.commands.comment.GetCommand;
import pl.polsl.mushrooms.application.commands.comment.UpdateCommand;
import pl.polsl.mushrooms.application.model.Comment;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public interface CommentService {

    void handle(CreateCommand command);

    Comment handle(GetCommand command);

    void handle(UpdateCommand command);

    void handle(DeleteCommand command);
}
