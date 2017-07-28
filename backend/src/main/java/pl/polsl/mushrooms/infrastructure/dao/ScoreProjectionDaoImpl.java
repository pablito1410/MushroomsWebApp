package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.ScoreProjectionDao;
import pl.polsl.mushrooms.application.model.Score;
import pl.polsl.mushrooms.infrastructure.dto.ScoreDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.ScoreRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */

public class ScoreProjectionDaoImpl implements ScoreProjectionDao {

    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;
    private final EntityMapper entityMapper;

    public ScoreProjectionDaoImpl(
            final ScoreRepository scoreRepository,
            final UserRepository userRepository,
            final EntityMapper entityMapper) {
        this.scoreRepository = scoreRepository;
        this.userRepository = userRepository;
        this.entityMapper = entityMapper;
    }

//    @Override
//    public Set<ScoreDto> findAll(long userId) {
//        final Mushroomer mushroomer = (Mushroomer)Optional
//                .ofNullable(userRepository.findOne(userId))
//                    .orElseThrow(EntityNotFoundException::new);
//
//        final Set<Score> scores = mushroomer.getScores();
//
//        return entityMapper.map(scores);
//    }

    @Override
    public Set<ScoreDto> findAll() {
        final List<Score> scores = scoreRepository.findAll();
        return entityMapper.map( scores);
    }

    @Override
    public ScoreDto findOne(long id) {
        final Score score = scoreRepository.findOne(id);
        return entityMapper.map(score);
    }

    @Override
    public Set<ScoreDto> search(String value) {
        return new HashSet<>();
    }

}
