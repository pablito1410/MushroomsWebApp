package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.MushroomGenus;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public interface MushroomGenusDao {

    MushroomGenus save(MushroomGenus mushroomGenus);

    MushroomGenus findOne(long id);

    void delete(long id);
}
