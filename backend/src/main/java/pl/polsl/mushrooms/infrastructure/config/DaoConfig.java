package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.polsl.mushrooms.application.dao.*;
import pl.polsl.mushrooms.infrastructure.dao.*;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;
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
    public TagDao tagDao(final TagRepository tagRepository) {
        return new TagDaoImpl(tagRepository);
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
    public MushroomSpeciesDao mushroomSpeciesDao(
            final MushroomSpeciesRepository mushroomSpeciesRepository
    ) {
        return new MushroomSpeciesDaoImpl(mushroomSpeciesRepository);
    }

    @Bean
    public MushroomSpeciesProjectionDao mushSpeciesProjectionDao(
            final MushroomSpeciesRepository mushroomSpeciesRepository,
            final EntityMapper entityMapper) {
        return new MushroomSpeciesProjectionDaoImpl(mushroomSpeciesRepository, entityMapper);
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

    @Bean CommentProjectionDao commentProjectionDao(
            final CommentRepository commentRepository,
            final EntityMapper entityMapper) {
        return new CommentProjectionDaoImpl(commentRepository, entityMapper);
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
    public  TagProjectionDao tagProjectionDao(
            final TagRepository tagRepository,
            final UserRepository userRepository,
            final DiscoveryRepository discoveryRepository,
            final EntityMapper entityMapper) {
        return new TagProjectionDaoImpl(tagRepository, userRepository, discoveryRepository, entityMapper);
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

    @Bean
    public MushroomClassDao mushroomClassDao(
            final MushroomClassRepository mushroomClassRepository) {
        return new MushroomClassDaoImpl(mushroomClassRepository);
    }

    @Bean
    public MushroomClassProjectionDao mushroomClassProjectionDao(
            final MushroomClassRepository mushroomClassRepository,
            final EntityMapper entityMapper) {
        return new MushroomClassProjectionDaoImpl(mushroomClassRepository, entityMapper);
    }

    @Bean
    public MushroomFamilyDao mushroomFamilyDao(
            final MushroomFamilyRepository mushroomFamilyRepository) {
        return new MushroomFamilyDaoImpl(mushroomFamilyRepository);
    }

    @Bean
    public MushroomFamilyProjectionDao mushroomFamilyProjectionDao(
            final MushroomFamilyRepository mushroomFamilyRepository,
            final EntityMapper entityMapper) {
        return new MushroomFamilyProjectionDaoImpl(mushroomFamilyRepository, entityMapper);
    }

    @Bean
    public MushroomOrderDao mushroomOrderDao(
            final MushroomOrderRepository mushroomOrderRepository) {
        return new MushroomOrderDaoImpl(mushroomOrderRepository);
    }

    @Bean
    public MushroomOrderProjectionDao mushroomOrderProjectionDao(
            final MushroomOrderRepository mushroomOrderRepository,
            final EntityMapper entityMapper) {
        return new MushroomOrderProjectionDaoImpl(mushroomOrderRepository, entityMapper);
    }

    @Bean
    public MushroomGenusDao mushroomGenusDao(
            final MushroomGenusRepository mushroomGenusRepository) {
        return new MushroomGenusDaoImpl(mushroomGenusRepository);
    }

    @Bean
    public MushroomGenusProjectionDao mushroomGenusProjectionDao(
            final MushroomGenusRepository mushroomGenusRepository,
            final EntityMapper entityMapper) {
        return new MushroomGenusProjectionDaoImpl(mushroomGenusRepository, entityMapper);
    }

}