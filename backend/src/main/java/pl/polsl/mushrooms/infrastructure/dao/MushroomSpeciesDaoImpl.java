package pl.polsl.mushrooms.infrastructure.dao;

import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.MushroomSpeciesDao;
import pl.polsl.mushrooms.application.model.MushroomSpecies;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
@Repository
public class MushroomSpeciesDaoImpl implements MushroomSpeciesDao {

    @Override
    public MushroomSpecies findOne(UUID mushroomSpieceId) {
        return null;
    }
}
