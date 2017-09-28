package pl.polsl.mushrooms.application.dao;

import java.util.Set;


public interface ProjectionDao<T> {

//    Set<T> findAll(User user);

    Set<T> findAll();

    T findOne(long id);

    Set<T> search(String value);

}
