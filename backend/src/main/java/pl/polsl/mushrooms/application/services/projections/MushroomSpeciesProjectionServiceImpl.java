package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.MushroomSpeciesProjectionDao;
import pl.polsl.mushrooms.infrastructure.dto.MushroomSpeciesDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 17.07.2017.
 */
public class MushroomSpeciesProjectionServiceImpl implements MushroomSpeciesProjectionService {

    private final MushroomSpeciesProjectionDao mushSpeciesProjectionDao;

    public MushroomSpeciesProjectionServiceImpl(MushroomSpeciesProjectionDao mushSpeciesProjectionDao) {
        this.mushSpeciesProjectionDao = mushSpeciesProjectionDao;
    }

    @Override
    public Set<MushroomSpeciesDto> findAll() {
        return mushSpeciesProjectionDao.findAll();
    }

    @Override
    public MushroomSpeciesDto findOne(long id) {
        return mushSpeciesProjectionDao.findOne(id);
    }

    @Override
    public Set<MushroomSpeciesDto> search(String value) {
        return mushSpeciesProjectionDao.search(value);
    }
}
