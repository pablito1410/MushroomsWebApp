package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.MushroomFamilyProjectionDao;
import pl.polsl.mushrooms.application.model.MushroomFamily;
import pl.polsl.mushrooms.infrastructure.dto.MushroomFamilyDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.MushroomFamilyRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public class MushroomFamilyProjectionDaoImpl implements MushroomFamilyProjectionDao {

    private final MushroomFamilyRepository mushroomFamilyRepository;
    private final EntityMapper entityMapper;

    public MushroomFamilyProjectionDaoImpl(
            final MushroomFamilyRepository mushroomFamilyRepository,
            final EntityMapper entityMapper) {
        this.mushroomFamilyRepository = mushroomFamilyRepository;
        this.entityMapper = entityMapper;
    }

//    @Override
//    public Set<MushroomFamilyDto> findAll(long userId) {
//        throw new NotYetImplementedException();
//    }

    @Override
    public Set<MushroomFamilyDto> findAll() {
        final List<MushroomFamily> mushroomFamilies = mushroomFamilyRepository.findAll();
        return entityMapper.map(mushroomFamilies);
    }

    @Override
    public MushroomFamilyDto findOne(long id) {
        final MushroomFamily mushroomFamily = mushroomFamilyRepository.findOne(id);
        return entityMapper.map(mushroomFamily);
    }

    @Override
    public Set<MushroomFamilyDto> search(String value) {
        final List<MushroomFamily> mushroomFamilies = mushroomFamilyRepository.findByNameIgnoreCaseContaining(value);
        return entityMapper.map(mushroomFamilies);
    }
}
