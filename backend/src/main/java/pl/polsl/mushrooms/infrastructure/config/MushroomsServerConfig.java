package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import pl.polsl.mushrooms.application.commands.comment.CreateCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.DeleteCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.UpdateCommentCommand;
import pl.polsl.mushrooms.application.commands.discovery.CreateDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.trip.CreateTripCommand;
import pl.polsl.mushrooms.application.commands.trip.DeleteTripCommand;
import pl.polsl.mushrooms.application.commands.trip.UpdateTripCommand;
import pl.polsl.mushrooms.application.commands.friend.AddFriendCommand;
import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
import pl.polsl.mushrooms.application.commands.user.DeleteUserCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateUserCommand;
import pl.polsl.mushrooms.application.dao.*;
import pl.polsl.mushrooms.application.services.*;
import pl.polsl.mushrooms.application.services.projections.*;
import pl.polsl.mushrooms.infrastructure.commands.CommandHandlerRegistry;
import pl.polsl.mushrooms.infrastructure.repositories.TripProjectionRepository;
import pl.polsl.mushrooms.infrastructure.repositories.TripRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UserProjectionRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;
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
            CommandHandlerRegistry registry) {
        return () -> {
            registry.register(userService::handle, CreateUserCommand.class);
            registry.register(userService::handle, UpdateUserCommand.class);
            registry.register(userService::handle, DeleteUserCommand.class);

            registry.register(friendService::handle, AddFriendCommand.class);


            registry.register(tripService::handle, CreateTripCommand.class);
            registry.register(tripService::handle, UpdateTripCommand.class);
            registry.register(tripService::handle, DeleteTripCommand.class);

            registry.register(discoveryService::handle, CreateDiscoveryCommand.class);
            registry.register(discoveryService::handle, UpdateDiscoveryCommand.class);
            registry.register(discoveryService::handle, DeleteDiscoveryCommand.class);

            registry.register(commentService::handle, CreateCommentCommand.class);
            registry.register(commentService::handle, UpdateCommentCommand.class);
            registry.register(commentService::handle, DeleteCommentCommand.class);
        };

    }

    @Bean
    public UserService userService(UserDao repo) {
        return new UserServiceImpl(repo);
    }

    @Bean
    public FriendService friendService(UserDao repo) {
        return new FriendServiceImpl(repo);
    }

    @Bean
    public TripService tripService(TripDao tripDao, UserDao userDao) { return new TripServiceImpl(userDao, tripDao); }

    @Bean
    public UserProjectionRepository userProjectionRepository(JdbcTemplate jdbcTemplate, UserRepository userRepository) {
        return new UserProjectionRepository(jdbcTemplate, userRepository);
    }

    @Bean
    public TripProjectionRepository tripProjectionRepository(final JdbcTemplate jdbcTemplate, final TripRepository tripRepository, final UserRepository userRepository) {
        return new TripProjectionRepository(jdbcTemplate, tripRepository, userRepository);
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
    DiscoveryProjectionService discoveryProjectionService() {
        return new DiscoveryProjectionServiceImpl();
    }

    @Bean
    TripProjectionService tripProjectionService(TripProjectionDao tripProjectionDao, UserProjectionService userProjectionService) {
        return new TripProjectionServiceImpl(tripProjectionDao, userProjectionService);
    }

    @Bean
    public DiscoveryService discoveryService(
            DiscoveryDao discoveryDao, TripDao tripDao, UserDao userDao, MushroomSpeciesDao mushroomSpeciesDao) {
        return new DiscoveryServiceImpl(discoveryDao, tripDao, userDao, mushroomSpeciesDao); }

    @Bean
    public CommentService commentService(UserDao userDao, CommentDao commentDao) {
        return new CommentServiceImpl(userDao, commentDao);
    }

    @Bean
    public UserDetailsService userDetailsService(final UserService userService) {
        return new CurrentUserDetailsService(userService);
    }
}
