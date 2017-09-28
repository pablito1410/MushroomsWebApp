package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.MushroomFamilyDto;

import java.util.Set;


public interface MushroomFamilyProjectionService {
    Set<MushroomFamilyDto> search(String value);

    Set<MushroomFamilyDto> findAll();

    MushroomFamilyDto findOne(long id);
}
