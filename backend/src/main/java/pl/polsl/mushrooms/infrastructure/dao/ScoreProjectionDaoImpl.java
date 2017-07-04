package pl.polsl.mushrooms.infrastructure.dao;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.ScoreProjectionDao;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.Score;
import pl.polsl.mushrooms.infrastructure.dto.ScoreDto;
import pl.polsl.mushrooms.infrastructure.repositories.ScoreRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.*;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */

@Repository
public class ScoreProjectionDaoImpl implements ScoreProjectionDao {

    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    public ScoreProjectionDaoImpl(ScoreRepository scoreRepository, UserRepository userRepository) {
        this.scoreRepository = scoreRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Set<ScoreDto> findAll(long userId) {
        final Mushroomer mushroomer = (Mushroomer)Optional
                .ofNullable(userRepository.findOne(userId))
                    .orElseThrow(EntityNotFoundException::new);

        final Set<Score> scores = mushroomer.getScores();

        return map(scores);
    }

    @Override
    public Set<ScoreDto> findAll() {
        final List<Score> scores = scoreRepository.findAll();
        return map(scores);
    }

    @Override
    public ScoreDto findOne(long id) {
        final Score score = scoreRepository.findOne(id);
        return map(score);
    }

    @Override
    public Set<ScoreDto> search(String value) {
        return new HashSet<>();
    }

    private static Set<ScoreDto> map(Collection<Score> scores) {
        return modelMapper.map(scores, new TypeToken<Set<Score>>() { }.getType());
    }

    private static ScoreDto map(Score score) {
        return modelMapper.map(score, ScoreDto.class);
    }
}
