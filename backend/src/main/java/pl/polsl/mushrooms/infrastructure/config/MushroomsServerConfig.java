package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import pl.polsl.mushrooms.application.dao.DiscoveryDao;
import pl.polsl.mushrooms.application.dao.TripDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.services.*;
import pl.polsl.mushrooms.infrastructure.commands.CommandHandlerRegistry;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@Configuration
public class MushroomsServerConfig {

    @Bean
    public InitializingBean mushroomsServerInitializer(
            UserService userService,
            TripService tripService,
            DiscoveryService discoveryService,
            CommentService commentService,
            CommandHandlerRegistry registry) {
        return () -> {
            registry.register(userService::handle, pl.polsl.mushrooms.application.commands.user.CreateCommand.class);
            registry.register(userService::handle, pl.polsl.mushrooms.application.commands.user.GetCommand.class);
            registry.register(userService::handle, pl.polsl.mushrooms.application.commands.user.UpdateCommand.class);
            registry.register(userService::handle, pl.polsl.mushrooms.application.commands.user.DeleteCommand.class);
            registry.register(userService::handle, pl.polsl.mushrooms.application.commands.user.GetAllUsersCommand.class);


            registry.register(tripService::handle, pl.polsl.mushrooms.application.commands.trip.CreateCommand.class);
            registry.register(tripService::handle, pl.polsl.mushrooms.application.commands.trip.UpdateCommand.class);
            registry.register(tripService::handle, pl.polsl.mushrooms.application.commands.trip.DeleteCommand.class);
            registry.register(tripService::handle, pl.polsl.mushrooms.application.commands.trip.GetCommand.class);

            registry.register(discoveryService::handle, pl.polsl.mushrooms.application.commands.discovery.CreateCommand.class);
            registry.register(discoveryService::handle, pl.polsl.mushrooms.application.commands.discovery.UpdateCommand.class);
            registry.register(discoveryService::handle, pl.polsl.mushrooms.application.commands.discovery.DeleteCommand.class);
            registry.register(discoveryService::handle, pl.polsl.mushrooms.application.commands.discovery.GetCommand.class);

            registry.register(commentService::handle, pl.polsl.mushrooms.application.commands.comment.CreateCommand.class);
            registry.register(commentService::handle, pl.polsl.mushrooms.application.commands.comment.UpdateCommand.class);
            registry.register(commentService::handle, pl.polsl.mushrooms.application.commands.comment.DeleteCommand.class);
            registry.register(commentService::handle, pl.polsl.mushrooms.application.commands.comment.GetCommand.class);


        };

    }

    @Bean
    public UserService userService(UserDao repo) {
        return new UserServiceImpl(repo);
    }

    @Bean
    public TripService tripService(TripDao tripDao, UserDao userDao) { return new TripServiceImpl(userDao, tripDao); }

    @Bean
    public DiscoveryService discoveryService(DiscoveryDao discoveryDao, TripDao tripDao) {
        return new DiscoveryServiceImpl(discoveryDao, tripDao); }

    @Bean
    public CommentService commentService() { return new CommentServiceImpl(); }

    @Bean
    public UserDetailsService userDetailsService(final UserService userService) {
        return new CurrentUserDetailsService(userService);
    }
}
