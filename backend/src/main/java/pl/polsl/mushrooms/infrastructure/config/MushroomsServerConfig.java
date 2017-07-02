package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import pl.polsl.mushrooms.application.commands.comment.CreateCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.DeleteCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.UpdateCommentCommand;
import pl.polsl.mushrooms.application.commands.discovery.AddScoreToDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.CreateDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.friend.AddFriendCommand;
import pl.polsl.mushrooms.application.commands.friend.DeleteFriendsCommand;
import pl.polsl.mushrooms.application.commands.notification.CreateNotificationCommand;
import pl.polsl.mushrooms.application.commands.notification.DeleteNotificationCommand;
import pl.polsl.mushrooms.application.commands.notification.UpdateNotificationCommand;
import pl.polsl.mushrooms.application.commands.score.AddScoreCommand;
import pl.polsl.mushrooms.application.commands.trip.CreateTripCommand;
import pl.polsl.mushrooms.application.commands.trip.DeleteTripCommand;
import pl.polsl.mushrooms.application.commands.trip.JoinTripCommand;
import pl.polsl.mushrooms.application.commands.trip.UpdateTripCommand;
import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
import pl.polsl.mushrooms.application.commands.user.DeleteUsersCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateProfileImageCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateUserCommand;
import pl.polsl.mushrooms.application.dao.*;
import pl.polsl.mushrooms.application.services.*;
import pl.polsl.mushrooms.application.services.projections.*;
import pl.polsl.mushrooms.infrastructure.commands.CommandHandlerRegistry;
import pl.polsl.mushrooms.application.dao.ScoreProjectionDao;
import pl.polsl.mushrooms.infrastructure.services.CurrentUserDetailsService;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@Configuration
public class MushroomsServerConfig {

    @Bean
    public InitializingBean mushroomsServerInitializer(
            UserService userService,
            FriendService friendService,
            TripService tripService,
            DiscoveryService discoveryService,
            CommentService commentService,
            ScoreService scoreService,
            NotificationService notificationService,
            CommandHandlerRegistry registry) {
        return () -> {
            registry.register(userService::handle, CreateUserCommand.class);
            registry.register(userService::handle, UpdateUserCommand.class);
            registry.register(userService::handle, DeleteUsersCommand.class);
            registry.register(userService::handle, UpdateProfileImageCommand.class);

            registry.register(friendService::handle, AddFriendCommand.class);
            registry.register(friendService::handle, DeleteFriendsCommand.class);


            registry.register(tripService::handle, CreateTripCommand.class);
            registry.register(tripService::handle, UpdateTripCommand.class);
            registry.register(tripService::handle, DeleteTripCommand.class);
            registry.register(tripService::handle, JoinTripCommand.class);

            registry.register(discoveryService::handle, CreateDiscoveryCommand.class);
            registry.register(discoveryService::handle, UpdateDiscoveryCommand.class);
            registry.register(discoveryService::handle, DeleteDiscoveryCommand.class);
            registry.register(discoveryService::handle, AddScoreToDiscoveryCommand.class);

            registry.register(commentService::handle, CreateCommentCommand.class);
            registry.register(commentService::handle, UpdateCommentCommand.class);
            registry.register(commentService::handle, DeleteCommentCommand.class);

            registry.register(scoreService:: handle, AddScoreCommand.class);

            registry.register(notificationService::handle, CreateNotificationCommand.class);
            registry.register(notificationService::handle, UpdateNotificationCommand.class);
            registry.register(notificationService::handle, DeleteNotificationCommand.class);
        };

    }

    @Bean
    public UserService userService(UserDao userDao) {
        return new UserServiceImpl(userDao);
    }

    @Bean
    public FriendService friendService(UserDao userDao) {
        return new FriendServiceImpl(userDao);
    }

    @Bean
    public TripService tripService(TripDao tripDao, UserDao userDao) { return new TripServiceImpl(userDao, tripDao); }

    @Bean
    public ScoreService scoreService(ScoreDao scoreDao, UserDao userDao, DiscoveryDao discoveryDao) {
        return new ScoreServiceImpl(scoreDao, userDao, discoveryDao); }

    @Bean
    ScoreProjectionService scoreProjectionService(ScoreProjectionDao scoreProjectionDao, UserProjectionService userProjectionService) {
        return new ScoreProjectionServiceImpl(scoreProjectionDao, userProjectionService);
    }

    @Bean
    UserProjectionService userProjectionService(UserProjectionDao userProjectionDao) {
        return new UserProjectionServiceImpl(userProjectionDao);
    }

    @Bean
    CommentProjectionService commentProjectionService() {
        return new CommentProjectionServiceImpl();
    }

    @Bean
    DiscoveryProjectionService discoveryProjectionService(final DiscoveryProjectionDao discoveryProjectionDao, UserProjectionService userProjectionService) {
        return new DiscoveryProjectionServiceImpl(discoveryProjectionDao, userProjectionService);
    }

    @Bean
    TripProjectionService tripProjectionService(TripProjectionDao tripProjectionDao, UserProjectionService userProjectionService) {
        return new TripProjectionServiceImpl(tripProjectionDao, userProjectionService);
    }

    @Bean
    MushSpeciesProjectionService mushSpeciesProjectionService(MushSpeciesProjectionDao mushSpeciesProjectionDao) {
        return new MushSpeciesProjectionServiceImpl(mushSpeciesProjectionDao);
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
    NotificationProjectionService notificationProjectionService(NotificationProjectionDao notificationProjectionDao,
                                                                UserProjectionDao userProjectionDao) {
        return new NotificationProjectionServiceImpl(notificationProjectionDao, userProjectionDao);
    }
}
