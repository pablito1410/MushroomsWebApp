package pl.polsl.mushrooms.application.services;

import org.springframework.security.core.context.SecurityContextHolder;
import pl.polsl.mushrooms.application.commands.score.AddScoreCommand;
import pl.polsl.mushrooms.application.dao.DiscoveryDao;
import pl.polsl.mushrooms.application.dao.ScoreDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Discovery;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.Score;

import javax.ws.rs.NotFoundException;
import java.util.Optional;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */
public class ScoreServiceImpl implements ScoreService {


    private final ScoreDao scoreDao;
    private final UserDao userDao;
    private final DiscoveryDao discoveryDao;

    public ScoreServiceImpl(ScoreDao scoreDao, UserDao userDao, DiscoveryDao discoveryDao) {
        this.scoreDao = scoreDao;
        this.userDao = userDao;
        this.discoveryDao = discoveryDao;
    }

    @Override
    public void handle(AddScoreCommand command) {
        final String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        final Mushroomer currentUser = (Mushroomer) Optional.ofNullable(
                userDao.findOneByUsername(currentUsername))
                    .orElseThrow(NotFoundException::new);

        final Discovery discovery = Optional.ofNullable(
                discoveryDao.findDiscovery(command.getDiscoveryId()))
                    .orElseThrow(NotFoundException::new);

        final Score score = new Score(
                command.getValue(),
                command.getDateTime(),
                discovery,
                currentUser
        );

        scoreDao.save(score);
    }
}
