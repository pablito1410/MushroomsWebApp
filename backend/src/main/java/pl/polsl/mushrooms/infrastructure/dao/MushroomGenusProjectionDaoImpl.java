package pl.polsl.mushrooms.infrastructure.dao;

import org.hibernate.cfg.NotYetImplementedException;
import pl.polsl.mushrooms.application.dao.MushroomGenusProjectionDao;
import pl.polsl.mushrooms.application.model.MushroomGenus;
import pl.polsl.mushrooms.infrastructure.dto.MushroomGenusDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.MushroomGenusRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public class MushroomGenusProjectionDaoImpl implements MushroomGenusProjectionDao {

    private final MushroomGenusRepository mushroomGenusRepository;
    private final EntityMapper entityMapper;

    public MushroomGenusProjectionDaoImpl(
            final MushroomGenusRepository mushroomGenusRepository, 
            final EntityMapper entityMapper) {
        this.mushroomGenusRepository = mushroomGenusRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Set<MushroomGenusDto> findAll(long userId) {
        throw new NotYetImplementedException();
    }

    @Override
    public Set<MushroomGenusDto> findAll() {
        final List<MushroomGenus> mushroomGenuses = mushroomGenusRepository.findAll();
        return entityMapper.map(mushroomGenuses);
    }

    @Override
    public MushroomGenusDto findOne(long id) {
        final MushroomGenus mushroomGenus = mushroomGenusRepository.findOne(id);
        return entityMapper.map(mushroomGenus);
    }

    @Override
    public Set<MushroomGenusDto> search(String value) {
        final List<MushroomGenus> mushroomGenuses
                = mushroomGenusRepository.findByNameIgnoreCaseContaining(value);
        return entityMapper.map(mushroomGenuses);
    }
}
