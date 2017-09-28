package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Score;


public interface ScoreDao {

    Score save(Score score);

    Score findOne(Long id);

    void delete(Score score);
}
