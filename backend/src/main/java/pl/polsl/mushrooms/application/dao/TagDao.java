package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Tag;

/**
 * Created by pawel_zaqkxkn on 17.07.2017.
 */
public interface TagDao {
    Tag save(Tag tag);

    Tag findOne(Long id);

    void delete(long id);
}
