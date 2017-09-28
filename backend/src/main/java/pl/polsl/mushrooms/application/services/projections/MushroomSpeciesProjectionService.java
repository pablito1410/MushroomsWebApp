package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.MushroomSpeciesDto;

import java.util.Set;


public interface MushroomSpeciesProjectionService {

    Set<MushroomSpeciesDto> findAll();

    MushroomSpeciesDto findOne(long id);

    Set<MushroomSpeciesDto> search(String value);

}
