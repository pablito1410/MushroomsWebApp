package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.MushroomSpeciesDao;
import pl.polsl.mushrooms.application.model.MushroomSpecies;
import pl.polsl.mushrooms.infrastructure.repositories.MushroomSpeciesRepository;


public class MushroomSpeciesDaoImpl implements MushroomSpeciesDao {

    private final MushroomSpeciesRepository mushroomSpeciesRepository;

    public MushroomSpeciesDaoImpl(
            final MushroomSpeciesRepository mushroomSpeciesRepository) {
        this.mushroomSpeciesRepository = mushroomSpeciesRepository;
    }

    @Override
    public MushroomSpecies save(final MushroomSpecies mushroomSpecies) {
        return mushroomSpeciesRepository.save(mushroomSpecies);
    }

    @Override
    public MushroomSpecies findOne(long mushroomSpeciesId) {
        return mushroomSpeciesRepository.findOne(mushroomSpeciesId);
    }

    @Override
    public void delete(long id) {
        mushroomSpeciesRepository.delete(id);
    }
}
