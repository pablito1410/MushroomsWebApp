package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.comment.CreateCommand;
import pl.polsl.mushrooms.application.commands.comment.DeleteCommand;
import pl.polsl.mushrooms.application.commands.comment.GetCommand;
import pl.polsl.mushrooms.application.commands.comment.UpdateCommand;
import pl.polsl.mushrooms.application.model.Comment;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class CommentServiceImpl implements CommentService {


    @Override
    public void handle(CreateCommand command) {

    }

    @Override
    public Comment handle(GetCommand command) {
        return null;
    }

    @Override
    public void handle(UpdateCommand command) {

    }

    @Override
    public void handle(DeleteCommand command) {

    }
}
