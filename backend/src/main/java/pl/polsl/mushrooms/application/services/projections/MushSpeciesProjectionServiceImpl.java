package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.MushSpeciesProjectionDao;
import pl.polsl.mushrooms.infrastructure.dto.MushroomSpeciesDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 27.06.2017.
 */
public class MushSpeciesProjectionServiceImpl implements MushSpeciesProjectionService {

    private final MushSpeciesProjectionDao mushSpeciesProjectionDao;

    public MushSpeciesProjectionServiceImpl(MushSpeciesProjectionDao mushSpeciesProjectionDao) {
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
}
