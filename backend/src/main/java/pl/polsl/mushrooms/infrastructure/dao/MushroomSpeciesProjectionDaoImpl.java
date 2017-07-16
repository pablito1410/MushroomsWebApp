package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.MushroomSpeciesProjectionDao;
import pl.polsl.mushrooms.application.model.MushroomSpecies;
import pl.polsl.mushrooms.infrastructure.dto.MushroomSpeciesDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.MushroomSpeciesRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 27.06.2017.
 */
public class MushroomSpeciesProjectionDaoImpl implements MushroomSpeciesProjectionDao {

    private final MushroomSpeciesRepository mushroomSpeciesRepository;
    private final EntityMapper entityMapper;

    public MushroomSpeciesProjectionDaoImpl(
            final MushroomSpeciesRepository mushroomSpeciesRepository,
            final EntityMapper entityMapper) {
        this.mushroomSpeciesRepository = mushroomSpeciesRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Set<MushroomSpeciesDto> findAll(long userId) {
        final Set<MushroomSpecies> mushroomSpecies = mushroomSpeciesRepository.findAllByDiscoveries_Mushroomer_Id(userId);
        return entityMapper.map(mushroomSpecies);
    }

    @Override
    public Set<MushroomSpeciesDto> findAll() {
        final List<MushroomSpecies> mushroomSpecies = mushroomSpeciesRepository.findAll();
        return entityMapper.map(mushroomSpecies);
    }

    @Override
    public MushroomSpeciesDto findOne(long id) {
        final MushroomSpecies mushroomSpecies = Optional.ofNullable(
                mushroomSpeciesRepository.findOne(id))
                    .orElseThrow(EntityNotFoundException::new);

        return entityMapper.map(mushroomSpecies);
    }

    @Override
    public Set<MushroomSpeciesDto> search(String value) {
        final List<MushroomSpecies> mushroomSpecies =
                mushroomSpeciesRepository.findByNameIgnoreCaseContaining(value);

        return entityMapper.map((Set<MushroomSpecies>)mushroomSpecies);
    }

}
