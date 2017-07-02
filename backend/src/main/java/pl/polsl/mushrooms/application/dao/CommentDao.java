package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Comment;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public interface CommentDao {

    Comment findOne(long targetId);

    void save(Comment comment);

    void delete(long id);
}
