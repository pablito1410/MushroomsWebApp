package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.MushroomSpecies;

public interface MushroomSpeciesDao {

    MushroomSpecies save(MushroomSpecies mushroomSpecies);

    MushroomSpecies findOne(long id);

    void delete(long id);
}
