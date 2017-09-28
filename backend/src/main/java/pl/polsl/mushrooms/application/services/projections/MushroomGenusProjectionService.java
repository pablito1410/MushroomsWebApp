package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.MushroomGenusDto;

import java.util.Set;


public interface MushroomGenusProjectionService {
    
    Set<MushroomGenusDto> search(String value);

    Set<MushroomGenusDto> findAll();

    MushroomGenusDto findOne(long id);
}
