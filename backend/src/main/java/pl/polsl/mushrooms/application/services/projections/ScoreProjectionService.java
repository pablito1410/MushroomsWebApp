package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.ScoreDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */
public interface ScoreProjectionService {

    Set<ScoreDto> findAll(String userName);

    ScoreDto findOne(long id);

    double discoveryScoresAverage(long discoveryId);
}
