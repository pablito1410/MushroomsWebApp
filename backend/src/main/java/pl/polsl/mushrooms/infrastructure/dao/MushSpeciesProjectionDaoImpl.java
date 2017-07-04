package pl.polsl.mushrooms.infrastructure.dao;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.MushSpeciesProjectionDao;
import pl.polsl.mushrooms.application.model.MushroomSpecies;
import pl.polsl.mushrooms.infrastructure.dto.MushroomSpeciesDto;
import pl.polsl.mushrooms.infrastructure.repositories.MushSpeciesRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 27.06.2017.
 */
@Repository
public class MushSpeciesProjectionDaoImpl implements MushSpeciesProjectionDao {

    private final MushSpeciesRepository mushSpeciesRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    public MushSpeciesProjectionDaoImpl(MushSpeciesRepository mushSpeciesRepository) {
        this.mushSpeciesRepository = mushSpeciesRepository;
    }

    @Override
    public Set<MushroomSpeciesDto> findAll(long userId) {
        final Set<MushroomSpecies> mushroomSpecies = mushSpeciesRepository.findAllByDiscoveries_Mushroomer_Id(userId);
        return map(mushroomSpecies);
    }

    @Override
    public Set<MushroomSpeciesDto> findAll() {
        final List<MushroomSpecies> mushroomSpecies = mushSpeciesRepository.findAll();
        return map(mushroomSpecies);
    }

    @Override
    public MushroomSpeciesDto findOne(long id) {
        final MushroomSpecies mushroomSpecies = Optional.ofNullable(
                mushSpeciesRepository.findOne(id))
                    .orElseThrow(EntityNotFoundException::new);

        return map(mushroomSpecies);
    }

    @Override
    public Set<MushroomSpeciesDto> search(String value) {
        final List<MushroomSpecies> mushroomSpecies =
                mushSpeciesRepository.findByNameIgnoreCaseContaining(value);

        return map(mushroomSpecies);
    }

    private static Set<MushroomSpeciesDto> map(Collection<MushroomSpecies> mushroomSpecies) {
        return modelMapper.map(mushroomSpecies, new TypeToken<Set<MushroomSpeciesDto>>() {}.getType());
    }

    private MushroomSpeciesDto map(MushroomSpecies mushroomSpecies) {
        return modelMapper.map(mushroomSpecies, MushroomSpeciesDto.class);
    }
}
