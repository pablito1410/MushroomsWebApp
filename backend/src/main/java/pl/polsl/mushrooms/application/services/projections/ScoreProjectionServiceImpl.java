package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.application.dao.ScoreProjectionDao;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */
public class ScoreProjectionServiceImpl implements ScoreProjectionService {


    private final ScoreProjectionDao scoreProjectionDao;
    private final UserProjectionService userProjectionService;

    public ScoreProjectionServiceImpl(ScoreProjectionDao scoreProjectionDao, UserProjectionService userProjectionService) {
        this.scoreProjectionDao = scoreProjectionDao;
        this.userProjectionService = userProjectionService;
    }
}
