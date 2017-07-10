package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.MushSpeciesProjectionDao;
import pl.polsl.mushrooms.application.model.MushroomSpecies;
import pl.polsl.mushrooms.infrastructure.dto.MushroomSpeciesDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.MushSpeciesRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 27.06.2017.
 */
public class MushSpeciesProjectionDaoImpl implements MushSpeciesProjectionDao {

    private final MushSpeciesRepository mushSpeciesRepository;
    private final EntityMapper entityMapper;

    public MushSpeciesProjectionDaoImpl(
            final MushSpeciesRepository mushSpeciesRepository,
            final EntityMapper entityMapper) {
        this.mushSpeciesRepository = mushSpeciesRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Set<MushroomSpeciesDto> findAll(long userId) {
        final Set<MushroomSpecies> mushroomSpecies = mushSpeciesRepository.findAllByDiscoveries_Mushroomer_Id(userId);
        return entityMapper.map(mushroomSpecies);
    }

    @Override
    public Set<MushroomSpeciesDto> findAll() {
        final List<MushroomSpecies> mushroomSpecies = mushSpeciesRepository.findAll();
        return entityMapper.map(mushroomSpecies);
    }

    @Override
    public MushroomSpeciesDto findOne(long id) {
        final MushroomSpecies mushroomSpecies = Optional.ofNullable(
                mushSpeciesRepository.findOne(id))
                    .orElseThrow(EntityNotFoundException::new);

        return entityMapper.map(mushroomSpecies);
    }

    @Override
    public Set<MushroomSpeciesDto> search(String value) {
        final List<MushroomSpecies> mushroomSpecies =
                mushSpeciesRepository.findByNameIgnoreCaseContaining(value);

        return entityMapper.map((Set<MushroomSpecies>)mushroomSpecies);
    }

}
