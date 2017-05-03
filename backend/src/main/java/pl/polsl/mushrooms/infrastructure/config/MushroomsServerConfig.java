package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import pl.polsl.mushrooms.application.commands.*;
import pl.polsl.mushrooms.application.dao.TripDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.services.*;
import pl.polsl.mushrooms.infrastructure.commands.CommandHandlerRegistry;
import pl.polsl.mushrooms.infrastructure.services.CurrentUserDetailsService;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@Configuration
public class MushroomsServerConfig {

    @Bean
    public InitializingBean mushroomsServerInitializer(TripService tripService, UserService userService, CommandHandlerRegistry registry) {
        return () -> {
            registry.register(userService::handle, CreateUserCommand.class);
            registry.register(userService::handle, GetUserCommand.class);
            registry.register(userService::handle, GetAllUsersCommand.class);
            registry.register(userService::handle, UpdateUserCommand.class);
            registry.register(userService::handle, DeleteUserCommand.class);
            registry.register(tripService::handle, CreateTripCommand.class);
            registry.register(tripService::handle, AddUserToTripCommand.class);

        };

    }

    @Bean
    public UserService userService(UserDao repo) {
        return new UserServiceImpl(repo);
    }

    @Bean
    public TripService tripService(TripDao tripDao, UserDao userDao) { return new TripServiceImpl(userDao, tripDao); }

    @Bean
    public UserDetailsService userDetailsService(final UserService userService) {
        return new CurrentUserDetailsService(userService);
    }
}
