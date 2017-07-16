package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.MushroomGenusDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public interface MushroomGenusProjectionService {
    
    Set<MushroomGenusDto> search(String value);

    Set<MushroomGenusDto> findAll();

    MushroomGenusDto findOne(long id);
}
