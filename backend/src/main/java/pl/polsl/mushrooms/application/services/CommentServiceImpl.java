package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.comment.CreateCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.DeleteCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.UpdateCommentCommand;
import pl.polsl.mushrooms.application.dao.CommentDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Comment;
import pl.polsl.mushrooms.application.model.Commentable;
import pl.polsl.mushrooms.application.model.User;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class CommentServiceImpl implements CommentService {


    private UserDao userDao;
    private CommentDao commentDao;

    public CommentServiceImpl(UserDao userDao, CommentDao commentDao) {
        this.userDao = userDao;
        this.commentDao = commentDao;
    }

    @Override
    public long handle(CreateCommentCommand command) {

        final User user = userDao.findOne(command.getUserId());
        final Commentable target = commentDao.findOne(command.getTargetId());
        final Comment comment = new Comment(command.getContents(), command.getDateTime(), target, user);

        commentDao.save(comment);

        return comment.getId();
    }

    @Override
    public void handle(UpdateCommentCommand command) {

    }

    @Override
    public void handle(DeleteCommentCommand command) {

    }
}
