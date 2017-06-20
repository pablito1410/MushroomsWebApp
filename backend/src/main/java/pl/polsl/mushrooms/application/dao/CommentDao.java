package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Commentable;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public interface CommentDao {

    Commentable findOne(long targetId);

    void save(Commentable comment);

    void delete(long id);
}
