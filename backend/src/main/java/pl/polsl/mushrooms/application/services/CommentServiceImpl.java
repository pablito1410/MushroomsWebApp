package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.comment.CreateCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.DeleteCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.UpdateCommentCommand;
import pl.polsl.mushrooms.application.dao.CommentDao;
import pl.polsl.mushrooms.application.dao.DiscoveryDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Comment;
import pl.polsl.mushrooms.application.model.Discovery;
import pl.polsl.mushrooms.application.model.User;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import java.util.Optional;


public class CommentServiceImpl implements CommentService {


    private final UserDao userDao;
    private final CommentDao commentDao;
    private final DiscoveryDao discoveryDao;

    public CommentServiceImpl(UserDao userDao,
                              CommentDao commentDao,
                              final DiscoveryDao discoveryDao) {
        this.userDao = userDao;
        this.commentDao = commentDao;
        this.discoveryDao = discoveryDao;
    }

    @Override
    public long handle(CreateCommentCommand command) {
        final String currentUsername = command.getUserName();
        final User user = userDao.findOneByUsername(currentUsername)
                .orElseThrow(EntityNotFoundException::new);

        final Long discoveryId = command.getDiscoveryId();
        final Long targetId = command.getTargetId();

        if (command.forDiscovery()) {
            final Discovery discovery = discoveryDao.findOne(command.getDiscoveryId())
                    .orElseThrow(EntityNotFoundException::new);
            final Comment comment = new Comment(command.getContents(), command.getDateTime(), null, user, discovery);
            commentDao.save(comment);
            return comment.getId();
        } else if (command.forTarget()){
            final Comment target = commentDao.findOne(command.getTargetId());
            final Comment comment = new Comment(command.getContents(), command.getDateTime(), target, user, null);
            commentDao.save(comment);
            return comment.getId();
        } else {
            throw new BadRequestException("discoveryId or targetId is required");
        }
    }

    @Override
    public void handle(UpdateCommentCommand command) {
        final String currentUsername = command.getUserName();
        final User user = userDao.findOneByUsername(currentUsername)
                .orElseThrow(EntityNotFoundException::new);;
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
        final String currentUsername = command.getUserName();
        final User user = userDao.findOneByUsername(currentUsername)
                .orElseThrow(EntityNotFoundException::new);;
        final Comment comment = (Comment) Optional.of(
                commentDao.findOne(command.getId()))
                    .orElseThrow(NotFoundException::new);

        if (!comment.getUser().equals(user)) {
            throw new NotAuthorizedException("This comment was not written by user with id=" + user.getId());
        }

        commentDao.delete(comment.getId());
    }
}
