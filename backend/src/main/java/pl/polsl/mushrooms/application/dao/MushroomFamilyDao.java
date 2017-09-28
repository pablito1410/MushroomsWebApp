package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.MushroomFamily;

public interface MushroomFamilyDao {

    MushroomFamily save(MushroomFamily mushroomFamily);

    MushroomFamily findOne(long id);

    void delete(long id);
}
