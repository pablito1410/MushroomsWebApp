package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.MushroomFamilyDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public interface MushroomFamilyProjectionService {
    Set<MushroomFamilyDto> search(String value);

    Set<MushroomFamilyDto> findAll();

    MushroomFamilyDto findOne(long id);
}
