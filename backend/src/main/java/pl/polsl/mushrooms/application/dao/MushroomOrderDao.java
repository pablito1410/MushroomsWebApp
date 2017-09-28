package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.MushroomOrder;

public interface MushroomOrderDao {

    MushroomOrder save(MushroomOrder mushroomOrder);

    MushroomOrder findOne(long id);

    void delete(long id);
}
