package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.MushroomFamilyProjectionDao;
import pl.polsl.mushrooms.infrastructure.dto.MushroomFamilyDto;

import java.util.Set;


public class MushroomFamilyProjectionServiceImpl implements MushroomFamilyProjectionService {

    private final MushroomFamilyProjectionDao mushroomFamilyProjectionDao;

    public MushroomFamilyProjectionServiceImpl(
            final MushroomFamilyProjectionDao mushroomFamilyProjectionDao) {
        this.mushroomFamilyProjectionDao = mushroomFamilyProjectionDao;
    }

    @Override
    public Set<MushroomFamilyDto> search(String value) {
        return mushroomFamilyProjectionDao.search(value);
    }

    @Override
    public Set<MushroomFamilyDto> findAll() {
        return mushroomFamilyProjectionDao.findAll();
    }

    @Override
    public MushroomFamilyDto findOne(long id) {
        return mushroomFamilyProjectionDao.findOne(id);
    }
}
