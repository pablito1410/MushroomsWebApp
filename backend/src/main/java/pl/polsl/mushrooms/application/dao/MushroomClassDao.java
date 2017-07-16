package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.MushroomClass;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public interface MushroomClassDao {

    MushroomClass save(MushroomClass mushroomClass);

    MushroomClass findOne(long id);

    void delete(long id);
}
