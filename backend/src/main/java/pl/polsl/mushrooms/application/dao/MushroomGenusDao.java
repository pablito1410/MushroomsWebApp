package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.MushroomGenus;

public interface MushroomGenusDao {

    MushroomGenus save(MushroomGenus mushroomGenus);

    MushroomGenus findOne(long id);

    void delete(long id);
}
