package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.MushroomGenusDao;
import pl.polsl.mushrooms.application.model.MushroomGenus;
import pl.polsl.mushrooms.infrastructure.repositories.MushroomGenusRepository;


public class MushroomGenusDaoImpl implements MushroomGenusDao {

    private final MushroomGenusRepository mushroomGenusRepository;

    public MushroomGenusDaoImpl(MushroomGenusRepository mushroomGenusRepository) {
        this.mushroomGenusRepository = mushroomGenusRepository;
    }

    @Override
    public MushroomGenus save(final MushroomGenus mushroomGenus) {
        return mushroomGenusRepository.save(mushroomGenus);
    }

    @Override
    public MushroomGenus findOne(long mushroomGenusId) {
        return mushroomGenusRepository.findOne(mushroomGenusId);
    }

    @Override
    public void delete(long mushroomGenusId) {
        mushroomGenusRepository.delete(mushroomGenusId);
    }
}
