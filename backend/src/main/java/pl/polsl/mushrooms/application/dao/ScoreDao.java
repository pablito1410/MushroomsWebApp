package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.Score;

/**
 * Created by pawel_zaqkxkn on 20.06.2017.
 */
public interface ScoreDao {

    Score save(Score score);

    Score findOne(Long id);

    void delete(Score score);
}
