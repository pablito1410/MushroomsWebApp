package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.MushroomFamily;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public interface MushroomFamilyDao {

    MushroomFamily save(MushroomFamily mushroomFamily);

    MushroomFamily findOne(long id);

    void delete(long id);
}
