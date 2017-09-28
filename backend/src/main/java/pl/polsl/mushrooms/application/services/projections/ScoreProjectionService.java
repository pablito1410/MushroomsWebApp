package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.ScoreDto;

import java.util.Set;


public interface ScoreProjectionService {

    Set<ScoreDto> findAll(String userName);

    ScoreDto findOne(long id);

    double discoveryScoresAverage(long discoveryId);
}
