package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.MushroomClassDao;
import pl.polsl.mushrooms.application.model.MushroomClass;
import pl.polsl.mushrooms.infrastructure.repositories.MushroomClassRepository;


public class MushroomClassDaoImpl implements MushroomClassDao {

    private MushroomClassRepository mushroomClassRepository;

    public MushroomClassDaoImpl(
            final MushroomClassRepository mushroomClassRepository) {

        this.mushroomClassRepository = mushroomClassRepository;
    }

    @Override
    public MushroomClass save(final MushroomClass mushroomClass) {
        return mushroomClassRepository.save(mushroomClass);
    }

    @Override
    public MushroomClass findOne(long id) {
        return mushroomClassRepository.findOne(id);
    }

    @Override
    public void delete(long id) {
        mushroomClassRepository.delete(id);
    }
}
