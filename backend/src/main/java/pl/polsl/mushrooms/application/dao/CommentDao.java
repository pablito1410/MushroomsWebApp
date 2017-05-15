package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Commentable;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public interface CommentDao {

    Commentable findOne(UUID targetId);

    void save(Commentable comment);
}
