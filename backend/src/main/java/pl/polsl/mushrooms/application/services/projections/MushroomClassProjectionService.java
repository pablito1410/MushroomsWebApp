package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.MushroomClassDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public interface MushroomClassProjectionService {

    Set<MushroomClassDto> search(String value);

    Set<MushroomClassDto> findAll();

    MushroomClassDto findOne(long id);
}
