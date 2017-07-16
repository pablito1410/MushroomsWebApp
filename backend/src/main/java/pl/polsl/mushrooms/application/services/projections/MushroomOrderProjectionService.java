package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.MushroomOrderDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public interface MushroomOrderProjectionService {

    Set<MushroomOrderDto> search(String value);

    Set<MushroomOrderDto> findAll();

    MushroomOrderDto findOne(long id);
}
