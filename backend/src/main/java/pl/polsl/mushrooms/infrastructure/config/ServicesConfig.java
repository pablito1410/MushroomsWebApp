package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import pl.polsl.mushrooms.application.dao.*;
import pl.polsl.mushrooms.application.model.MushroomOrder;
import pl.polsl.mushrooms.application.services.*;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.services.CurrentUserDetailsService;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */

@Configuration
public class ServicesConfig {

    @Bean
    public UserService userService(UserDao userDao, EntityMapper entityMapper) {
        return new UserServiceImpl(userDao, entityMapper);
    }

    @Bean
    public FriendService friendService(
            final UserDao userDao,
            final NotificationDao notificationDao) {
        return new FriendServiceImpl(userDao, notificationDao);
    }

    @Bean
    public TripService tripService(TripDao tripDao, UserDao userDao) { return new TripServiceImpl(userDao, tripDao); }

    @Bean
    public ScoreService scoreService(ScoreDao scoreDao, UserDao userDao, DiscoveryDao discoveryDao) {
        return new ScoreServiceImpl(scoreDao, userDao, discoveryDao); }

    @Bean
    public TagService tagService(
            final DiscoveryDao discoveryDao,
            final TagDao tagDao,
            final EntityMapper entityMapper) {
        return new TagServiceImpl(discoveryDao, tagDao, entityMapper);
    }

    @Bean
    public DiscoveryService discoveryService(
            DiscoveryDao discoveryDao, TripDao tripDao, UserDao userDao, MushroomSpeciesDao mushroomSpeciesDao, ScoreDao scoreDao) {
        return new DiscoveryServiceImpl(discoveryDao, tripDao, userDao, mushroomSpeciesDao, scoreDao); }

    @Bean
    public CommentService commentService(UserDao userDao, CommentDao commentDao) {
        return new CommentServiceImpl(userDao, commentDao);
    }

    @Bean
    public UserDetailsService userDetailsService(final UserService userService) {
        return new CurrentUserDetailsService(userService);
    }

    @Bean
    public NotificationService notificationService(NotificationDao notificationDao, UserDao userDao) {
        return new NotificationServiceImpl(notificationDao, userDao);
    }

    @Bean
    public MushroomClassService mushroomClassService(
            final MushroomClassDao mushroomClassDao, final EntityMapper entityMapper) {
        return new MushroomClassServiceImpl(mushroomClassDao, entityMapper);
    }

    @Bean
    public MushroomOrderService mushroomOrderService(
            final MushroomClassDao mushroomClassDao,
            final MushroomOrderDao mushroomOrderDao,
            final EntityMapper entityMapper) {
        return new MushroomOrderServiceImpl(mushroomClassDao, mushroomOrderDao, entityMapper);
    }

    @Bean
    public MushroomFamilyService mushroomFamilyService(
            final MushroomOrderDao mushroomOrderDao,
            final MushroomFamilyDao mushroomFamilyDao,
            final EntityMapper entityMapper) {
        return new MushroomFamilyServiceImpl(mushroomOrderDao, mushroomFamilyDao, entityMapper);
    }

    @Bean
    public MushroomGenusService mushroomGenusService(
            final MushroomFamilyDao mushroomFamilyDao,
            final MushroomGenusDao mushroomGenusDao,
            final EntityMapper entityMapper) {
        return new MushroomGenusServiceImpl(mushroomFamilyDao, mushroomGenusDao, entityMapper);
    }

    @Bean
    public MushroomSpeciesService mushroomSpeciesService(
            final MushroomGenusDao mushroomGenusDao,
            final MushroomSpeciesDao mushroomSpeciesDao,
            final EntityMapper entityMapper) {
        return new MushroomSpeciesServiceImpl(mushroomGenusDao, mushroomSpeciesDao, entityMapper);
    }

}
