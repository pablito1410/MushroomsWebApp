package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.MushroomOrderProjectionDao;
import pl.polsl.mushrooms.infrastructure.dto.MushroomOrderDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public class MushroomOrderProjectionServiceImpl implements MushroomOrderProjectionService {

    private final MushroomOrderProjectionDao mushroomOrderProjectionDao;

    public MushroomOrderProjectionServiceImpl(
            final MushroomOrderProjectionDao mushroomOrderProjectionDao) {
        this.mushroomOrderProjectionDao = mushroomOrderProjectionDao;
    }

    @Override
    public Set<MushroomOrderDto> search(String value) {
        return mushroomOrderProjectionDao.search(value);
    }

    @Override
    public Set<MushroomOrderDto> findAll() {
        return mushroomOrderProjectionDao.findAll();
    }

    @Override
    public MushroomOrderDto findOne(long id) {
        return mushroomOrderProjectionDao.findOne(id);
    }
}
