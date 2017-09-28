package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.MushroomClassProjectionDao;
import pl.polsl.mushrooms.infrastructure.dto.MushroomClassDto;

import java.util.Set;


public class MushroomClassProjectionServiceImpl implements MushroomClassProjectionService {

    private final MushroomClassProjectionDao mushroomClassProjectionDao;

    public MushroomClassProjectionServiceImpl(
            final MushroomClassProjectionDao mushroomClassProjectionDao) {
        this.mushroomClassProjectionDao = mushroomClassProjectionDao;
    }

    @Override
    public Set<MushroomClassDto> search(String value) {
        return mushroomClassProjectionDao.search(value);
    }

    @Override
    public Set<MushroomClassDto> findAll() {
        return mushroomClassProjectionDao.findAll();
    }

    @Override
    public MushroomClassDto findOne(long id) {
        return mushroomClassProjectionDao.findOne(id);
    }
}
