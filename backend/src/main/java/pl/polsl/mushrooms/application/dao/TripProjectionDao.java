package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.infrastructure.dto.TripDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public interface TripProjectionDao extends ProjectionDao {

    Set<TripDto> findAll(long userId, Projection projection);
}
