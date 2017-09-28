package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Tag;


public interface TagDao {
    Tag save(Tag tag);

    Tag findOne(Long id);

    void delete(long id);
}
