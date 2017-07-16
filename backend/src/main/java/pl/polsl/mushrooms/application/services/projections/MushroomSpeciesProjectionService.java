package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.MushroomSpeciesDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 17.07.2017.
 */
public interface MushroomSpeciesProjectionService {

    Set<MushroomSpeciesDto> findAll();

    MushroomSpeciesDto findOne(long id);

    Set<MushroomSpeciesDto> search(String value);

}
