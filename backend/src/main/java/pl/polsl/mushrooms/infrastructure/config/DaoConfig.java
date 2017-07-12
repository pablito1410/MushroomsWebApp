package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.polsl.mushrooms.application.dao.*;
import pl.polsl.mushrooms.infrastructure.dao.*;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.*;

/**
 * Created by pawel_zaqkxkn on 08.07.2017.
 */

@Configuration
public class DaoConfig {

    @Bean
    public CommentDao commentDao(final CommentRepository commentRepository) {
        return new CommentDaoImpl(commentRepository);
    }

    @Bean
    public DiscoveryDao discoveryDao(final DiscoveryRepository DiscoveryRepository) {
        return new DiscoveryDaoImpl(DiscoveryRepository);
    }

    @Bean
    public DiscoveryProjectionDao discoveryProjectionDao(
            final DiscoveryRepository discoveryRepository,
            final UserRepository userRepository,
            final EntityMapper entityMapper) {
        return new DiscoveryProjectionDaoImpl(
                discoveryRepository, userRepository, entityMapper);
    }

    @Bean
    public MushroomSpeciesDao mushroomSpeciesDao() {
        return new MushroomSpeciesDaoImpl();
    }

    @Bean
    public MushSpeciesProjectionDao mushSpeciesProjectionDao(
            final MushSpeciesRepository mushSpeciesRepository,
            final EntityMapper entityMapper) {
        return new MushSpeciesProjectionDaoImpl(mushSpeciesRepository, entityMapper);
    }

    @Bean
    public NotificationDao notificationDao(
            final NotificationRepository notificationRepository) {
        return new NotificationDaoImpl(notificationRepository);
    }

    @Bean
    public NotificationProjectionDao notificationProjectionDao(
            final NotificationRepository notificationRepository,
            final UserRepository userRepository,
            final EntityMapper entityMapper) {
        return new NotificationProjectionDaoImpl(notificationRepository, userRepository, entityMapper);
    }

    @Bean
    public ScoreDao scoreDao(final ScoreRepository scoreRepository) {
        return new ScoreDaoImpl(scoreRepository);
    }

    @Bean
    public ScoreProjectionDao scoreProjectionDao(
            final ScoreRepository scoreRepository,
            final UserRepository userRepository,
            final EntityMapper entityMapper) {
        return new ScoreProjectionDaoImpl(scoreRepository, userRepository, entityMapper);
    }

    @Bean
    public TripDao tripDao(
            final TripRepository tripRepository,
            final UsersTripsRepository usersTripsRepository) {
        return new TripDaoImpl(tripRepository, usersTripsRepository);
    }


    @Bean
    public TripProjectionDao tripProjectionDao(final TripRepository tripRepository,
                                               final UserRepository userRepository,
                                               final EntityMapper entityMapper) {
        return new TripProjectionDaoImpl(tripRepository, userRepository, entityMapper);
    }

    @Bean
    public UserDao userDao(final UserRepository userRepository,
                           final UsersUsersRepository usersUsersRepository) {
        return new UserDaoImpl(userRepository, usersUsersRepository);
    }

    @Bean
    public UserProjectionDao userProjectionDao(final UserRepository userRepository,
                                               final EntityMapper entityMapper) {
        return new UserProjectionDaoImpl(userRepository, entityMapper);
    }

}
