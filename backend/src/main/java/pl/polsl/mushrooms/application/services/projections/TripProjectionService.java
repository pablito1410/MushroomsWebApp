package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.TripDto;

import java.util.Map;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public interface TripProjectionService {

    Map<String,Object> findOne(long id);

    Set<TripDto> findAll(String userName);

    Set<TripDto> findAll(long userId);
}
