package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.MushroomClass;

public interface MushroomClassDao {

    MushroomClass save(MushroomClass mushroomClass);

    MushroomClass findOne(long id);

    void delete(long id);
}
