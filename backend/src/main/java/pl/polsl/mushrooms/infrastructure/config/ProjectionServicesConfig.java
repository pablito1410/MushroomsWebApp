package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.polsl.mushrooms.application.dao.*;
import pl.polsl.mushrooms.application.services.projections.*;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */

@Configuration
public class ProjectionServicesConfig {

    @Bean
    public NotificationProjectionService notificationProjectionService(
            final NotificationProjectionDao notificationProjectionDao,
            final UserDao userDao,
            final EntityMapper entityMapper) {
        return new NotificationProjectionServiceImpl(notificationProjectionDao, userDao, entityMapper);
    }

    @Bean
    public ScoreProjectionService scoreProjectionService(
            final ScoreProjectionDao scoreProjectionDao,
            final DiscoveryDao discoveryDao,
            final UserDao userDao,
            final EntityMapper entityMapper) {
        return new ScoreProjectionServiceImpl(scoreProjectionDao, discoveryDao, userDao, entityMapper);
    }

    @Bean
    public TagProjectionService tagProjectionService(
            final TagProjectionDao tagProjectionDao,
            final UserDao userDao) {
        return new TagProjecitonServiceImpl(tagProjectionDao, userDao);
    }

    @Bean
    public UserProjectionService userProjectionService(
            final UserProjectionDao userProjectionDao,
            final UserDao userDao,
            final EntityMapper entityMapper) {
        return new UserProjectionServiceImpl(userProjectionDao, userDao, entityMapper);
    }

    @Bean
    public CommentProjectionService commentProjectionService(
            final CommentProjectionDao commentDao,
            final UserDao userDao,
            final EntityMapper entityMapper) {
        return new CommentProjectionServiceImpl(commentDao, userDao, entityMapper);
    }

    @Bean
    public DiscoveryProjectionService discoveryProjectionService(
            final DiscoveryProjectionDao discoveryProjectionDao,
            final UserDao userDao,
            final EntityMapper entityMapper) {
        return new DiscoveryProjectionServiceImpl(discoveryProjectionDao, userDao, entityMapper);
    }

    @Bean
    public TripProjectionService tripProjectionService(
            final TripProjectionDao tripProjectionDao,
            final UserDao userDao,
            final EntityMapper entityMapper) {
        return new TripProjectionServiceImpl(tripProjectionDao, userDao, entityMapper);
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

    @Bean
    public FriendProjectionService friendProjectionService(
            final FriendProjectionDao friendProjectionDao,
            final UserDao userDao,
            final EntityMapper entityMapper) {
        return new FriendProjectionServiceImpl(entityMapper, userDao, friendProjectionDao);
    }

}
