package pl.polsl.mushrooms.application.services;

import org.springframework.security.core.context.SecurityContextHolder;
import pl.polsl.mushrooms.application.commands.comment.CreateCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.DeleteCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.UpdateCommentCommand;
import pl.polsl.mushrooms.application.dao.CommentDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Comment;
import pl.polsl.mushrooms.application.model.User;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import java.util.Optional;

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
        final String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        final User user = userDao.findOneByUsername(currentUsername);
        final Comment target = commentDao.findOne(command.getTargetId());
        final Comment comment = new Comment(command.getContents(), command.getDateTime(), target, user);

        commentDao.save(comment);

        return comment.getId();
    }

    @Override
    public void handle(UpdateCommentCommand command) {
        final String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        final User user = userDao.findOneByUsername(currentUsername);
        final Comment comment = (Comment) Optional.of(
                commentDao.findOne(command.getId()))
                    .orElseThrow(NotFoundException::new);

        if (!comment.getUser().equals(user)) {
            throw new NotAuthorizedException("This comment was not written by user with id=" + user.getId());
        }

        comment.setContent(command.getContents());
    }

    @Override
    public void handle(DeleteCommentCommand command) {
        final String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        final User user = userDao.findOneByUsername(currentUsername);
        final Comment comment = (Comment) Optional.of(
                commentDao.findOne(command.getId()))
                    .orElseThrow(NotFoundException::new);

        if (!comment.getUser().equals(user)) {
            throw new NotAuthorizedException("This comment was not written by user with id=" + user.getId());
        }

        commentDao.delete(comment.getId());
    }
}
