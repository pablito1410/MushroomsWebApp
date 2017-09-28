package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.ScoreDao;
import pl.polsl.mushrooms.application.model.Score;
import pl.polsl.mushrooms.infrastructure.repositories.ScoreRepository;


public class ScoreDaoImpl implements ScoreDao {

    ScoreRepository scoreRepository;

    public ScoreDaoImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public Score save(Score score) {
        return scoreRepository.save(score);
    }

    @Override
    public Score findOne(Long id) {
        return scoreRepository.findOne(id);
    }

    @Override
    public void delete(Score score) {
        scoreRepository.delete(score);
    }
}
