package pl.polsl.mushrooms.infrastructure.dao;

import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.CommentDao;
import pl.polsl.mushrooms.application.model.Comment;
import pl.polsl.mushrooms.infrastructure.repositories.CommentRepository;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
@Repository
public class CommentDaoImpl implements CommentDao {

    private CommentRepository commentRepository;

    public CommentDaoImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment findOne(long commentId) {
        return commentRepository.findOne(commentId);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(long id) {
        commentRepository.delete(id);
    }
}
