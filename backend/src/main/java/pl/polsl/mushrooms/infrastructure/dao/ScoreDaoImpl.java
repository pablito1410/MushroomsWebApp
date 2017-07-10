package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.ScoreDao;
import pl.polsl.mushrooms.application.model.Score;
import pl.polsl.mushrooms.infrastructure.repositories.ScoreRepository;

/**
 * Created by pawel_zaqkxkn on 20.06.2017.
 */
public class ScoreDaoImpl implements ScoreDao {

    ScoreRepository scoreRepository;

    public ScoreDaoImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public Score save(Score score) {
        return scoreRepository.save(score);
    }
}
