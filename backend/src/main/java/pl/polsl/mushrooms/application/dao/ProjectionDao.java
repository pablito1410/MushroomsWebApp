package pl.polsl.mushrooms.application.dao;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 13.05.2017.
 */
public interface ProjectionDao<T> {

    Set<T> findAll(long userId);

    Set<T> findAll();

    T findOne(long id);

    Set<T> search(String value);

}
