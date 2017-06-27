package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.infrastructure.dto.MushroomSpeciesDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 27.06.2017.
 */
public interface MushSpeciesProjectionDao {
    Set<MushroomSpeciesDto> findAll();

    MushroomSpeciesDto findOne(long id);
}
