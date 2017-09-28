package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Comment;

public interface CommentDao {

    Comment findOne(long targetId);

    void save(Comment comment);

    void delete(long id);
}
