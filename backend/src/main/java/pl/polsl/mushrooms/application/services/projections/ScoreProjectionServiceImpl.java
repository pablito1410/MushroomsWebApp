package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.DiscoveryDao;
import pl.polsl.mushrooms.application.dao.ScoreProjectionDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Discovery;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.ScoreDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

import javax.persistence.EntityNotFoundException;
import java.util.Set;


public class ScoreProjectionServiceImpl implements ScoreProjectionService {


    private final ScoreProjectionDao scoreProjectionDao;
    private final DiscoveryDao discoveryDao;
    private final UserDao userDao;
    private final EntityMapper entityMapper;

    public ScoreProjectionServiceImpl(
            final ScoreProjectionDao scoreProjectionDao,
            final DiscoveryDao discoveryDao,
            final UserDao userDao, EntityMapper entityMapper) {
        this.scoreProjectionDao = scoreProjectionDao;
        this.discoveryDao = discoveryDao;
        this.userDao = userDao;
        this.entityMapper = entityMapper;
    }

    @Override
    public Set<ScoreDto> findAll(String userName) {
        final User user = userDao.findOneByUsername(userName)
                .orElseThrow(EntityNotFoundException::new);
        if (user.isAdmin()) {
            return scoreProjectionDao.findAll();
        } else {
            return entityMapper.map(((Mushroomer)user).getScores());
        }
    }

    @Override
    public ScoreDto findOne(long id) {
        return scoreProjectionDao.findOne(id);
    }

    @Override
    public double discoveryScoresAverage(long discoveryId) {
        final Discovery discovery = discoveryDao.findOne(discoveryId)
                .orElseThrow(EntityNotFoundException::new);
        return discovery.scoresAverage();
    }
}
