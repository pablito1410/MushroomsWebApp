package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.CommentProjectionDao;
import pl.polsl.mushrooms.application.model.Comment;
import pl.polsl.mushrooms.infrastructure.dto.CommentDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.CommentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 28.07.2017.
 */
public class CommentProjectionDaoImpl implements CommentProjectionDao {
    
    private final CommentRepository commentRepository;
    private final EntityMapper entityMapper;

    public CommentProjectionDaoImpl(
            final CommentRepository commentRepository,
            final EntityMapper entityMapper) {
        this.commentRepository = commentRepository;
        this.entityMapper = entityMapper;
    }

//    @Override
//    public Set<CommentDto> findAll(Mushroomer user) {
//        if (user instanceof Mushroomer) {
//            final Set<Comment> comments = ((Mushroomer) user).getComments();
//            return entityMapper.map(comments);
//        } else {
//            throw new IllegalStateException("User is not instance of Mushroomer");
//        }
//    }

    @Override
    public Set<CommentDto> findAll() {
        final List<Comment> discoveries = commentRepository.findAll();
        return entityMapper.map(discoveries);
    }

    @Override
    public CommentDto findOne(long id) {
        final Comment comment = Optional
                .ofNullable(commentRepository.findOne(id))
                .orElseThrow(EntityNotFoundException::new);
        return entityMapper.map(comment);
    }

    @Override
    public Set<CommentDto> search(String value) {
        final Set<Comment> discoveries = commentRepository.findByContentIgnoreCaseContaining(value);
        return entityMapper.map(discoveries);
    }
}
