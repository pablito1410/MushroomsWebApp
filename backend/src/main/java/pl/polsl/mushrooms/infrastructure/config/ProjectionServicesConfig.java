package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.polsl.mushrooms.application.dao.*;
import pl.polsl.mushrooms.application.services.projections.*;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */

@Configuration
public class ProjectionServicesConfig {

    @Bean
    public NotificationProjectionService notificationProjectionService(NotificationProjectionDao notificationProjectionDao,
                                                                       UserProjectionDao userProjectionDao) {
        return new NotificationProjectionServiceImpl(notificationProjectionDao, userProjectionDao);
    }

    @Bean
    public ScoreProjectionService scoreProjectionService(ScoreProjectionDao scoreProjectionDao, UserProjectionService userProjectionService) {
        return new ScoreProjectionServiceImpl(scoreProjectionDao, userProjectionService);
    }

    @Bean
    public UserProjectionService userProjectionService(UserProjectionDao userProjectionDao, UserDao userDao) {
        return new UserProjectionServiceImpl(userProjectionDao, userDao);
    }

    @Bean
    public CommentProjectionService commentProjectionService() {
        return new CommentProjectionServiceImpl();
    }

    @Bean
    public DiscoveryProjectionService discoveryProjectionService(final DiscoveryProjectionDao discoveryProjectionDao, UserProjectionService userProjectionService) {
        return new DiscoveryProjectionServiceImpl(discoveryProjectionDao, userProjectionService);
    }

    @Bean
    public TripProjectionService tripProjectionService(TripProjectionDao tripProjectionDao, UserProjectionService userProjectionService) {
        return new TripProjectionServiceImpl(tripProjectionDao, userProjectionService);
    }

    @Bean
    public MushroomClassProjectionService mushroomClassProjectionService(
            final MushroomClassProjectionDao mushroomClassProjectionDao) {
        return new MushroomClassProjectionServiceImpl(mushroomClassProjectionDao);
    }

    @Bean
    public MushroomOrderProjectionService mushroomOrderProjectionService(
            final MushroomOrderProjectionDao mushroomOrderProjectionDao) {
        return new MushroomOrderProjectionServiceImpl(mushroomOrderProjectionDao);
    }

    @Bean
    public MushroomFamilyProjectionService mushroomFamilyProjectionService(
            final MushroomFamilyProjectionDao mushroomFamilyProjectionDao) {
        return new MushroomFamilyProjectionServiceImpl(mushroomFamilyProjectionDao);
    }

    @Bean
    public MushroomGenusProjectionService mushroomGenusProjectionService(
            final MushroomGenusProjectionDao mushroomGenusProjectionDao) {
        return new MushroomGenusProjectionServiceImpl(mushroomGenusProjectionDao);
    }

    @Bean
    public MushroomSpeciesProjectionService mushroomSpeciesProjectionService(
            final MushroomSpeciesProjectionDao mushroomSpeciesProjectionDao) {
        return new MushroomSpeciesProjectionServiceImpl(mushroomSpeciesProjectionDao);
    }

}
