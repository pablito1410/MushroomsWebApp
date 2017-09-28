package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.MushroomClassProjectionDao;
import pl.polsl.mushrooms.application.model.MushroomClass;
import pl.polsl.mushrooms.infrastructure.dto.MushroomClassDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.MushroomClassRepository;

import java.util.List;
import java.util.Set;


public class MushroomClassProjectionDaoImpl implements MushroomClassProjectionDao {

    private final MushroomClassRepository mushroomClassRepository;
    private final EntityMapper entityMapper;

    public MushroomClassProjectionDaoImpl(
            final MushroomClassRepository mushroomClassRepository,
            final EntityMapper entityMapper) {
        this.mushroomClassRepository = mushroomClassRepository;
        this.entityMapper = entityMapper;
    }

//    @Override
//    public Set<MushroomClassDto> findAll(long userId) {
//        throw new NotYetImplementedException();
//    }

    @Override
    public Set<MushroomClassDto> findAll() {
        final List<MushroomClass> mushroomClasses = mushroomClassRepository.findAll();
        return entityMapper.map(mushroomClasses);
    }

    @Override
    public MushroomClassDto findOne(long id) {
        final MushroomClass mushroomClass = mushroomClassRepository.findOne(id);
        return entityMapper.map(mushroomClass);
    }

    @Override
    public Set<MushroomClassDto> search(String value) {
        final List<MushroomClass> mushroomClasses
                = mushroomClassRepository.findByNameIgnoreCaseContaining(value);
        return entityMapper.map(mushroomClasses);
    }
}
