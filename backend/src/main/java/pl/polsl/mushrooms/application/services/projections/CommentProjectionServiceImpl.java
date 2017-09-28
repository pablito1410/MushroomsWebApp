package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.CommentProjectionDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.CommentDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

import javax.persistence.EntityNotFoundException;
import java.util.Set;


public class CommentProjectionServiceImpl implements CommentProjectionService {

    private final CommentProjectionDao commentProjectionDao;
    private final UserDao userDao;
    private final EntityMapper entityMapper;

    public CommentProjectionServiceImpl(CommentProjectionDao commentProjectionDao, UserDao userDao, EntityMapper entityMapper) {
        this.commentProjectionDao = commentProjectionDao;
        this.userDao = userDao;
        this.entityMapper = entityMapper;
    }

    @Override
    public CommentDto findOne(long id) {
        return commentProjectionDao.findOne(id);
    }

    @Override
    public Set<CommentDto> findAll(String userName) {
        final User user = userDao.findOneByUsername(userName)
                .orElseThrow(EntityNotFoundException::new);
        if (user.isAdmin()) {
            return commentProjectionDao.findAll();
        } else {
            return entityMapper.map(user.getComments());
        }
    }
}
