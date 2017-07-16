package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.MushroomGenusProjectionDao;
import pl.polsl.mushrooms.infrastructure.dto.MushroomGenusDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public class MushroomGenusProjectionServiceImpl implements MushroomGenusProjectionService {

    private final MushroomGenusProjectionDao mushroomGenusProjectionDao;

    public MushroomGenusProjectionServiceImpl(
            final MushroomGenusProjectionDao mushroomGenusProjectionDao) {
        this.mushroomGenusProjectionDao = mushroomGenusProjectionDao;
    }

    @Override
    public Set<MushroomGenusDto> search(String value) {
        return mushroomGenusProjectionDao.search(value);
    }

    @Override
    public Set<MushroomGenusDto> findAll() {
        return mushroomGenusProjectionDao.findAll();
    }

    @Override
    public MushroomGenusDto findOne(long id) {
        return mushroomGenusProjectionDao.findOne(id);
    }
}
