package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.MushroomOrder;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public interface MushroomOrderDao {

    MushroomOrder save(MushroomOrder mushroomOrder);

    MushroomOrder findOne(long id);

    void delete(long id);
}
