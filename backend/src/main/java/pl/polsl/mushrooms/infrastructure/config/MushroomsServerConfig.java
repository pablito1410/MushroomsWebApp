package pl.polsl.mushrooms.infrastructure.config;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import pl.polsl.mushrooms.application.commands.*;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.services.CurrentUserDetailsService;
import pl.polsl.mushrooms.application.services.UserService;
import pl.polsl.mushrooms.application.services.UserServiceImpl;
import pl.polsl.mushrooms.infrastructure.commands.CommandHandlerRegistry;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@Configuration
public class MushroomsServerConfig {

    @Bean
    public InitializingBean mushroomsServerInitializer(UserService userService, CommandHandlerRegistry registry) {
        return () -> {
            registry.register(userService::handle, CreateUserCommand.class);
            registry.register(userService::handle, GetUserCommand.class);
            registry.register(userService::handle, GetAllUsersCommand.class);
            registry.register(userService::handle, UpdateUserCommand.class);
            registry.register(userService::handle, DeleteUserCommand.class);
        };

    }

    @Bean
    public UserService userService(UserDao repo) {
        return new UserServiceImpl(repo);
    }

    @Bean
    public UserDetailsService userDetailsService(final UserService userService) {
        return new CurrentUserDetailsService(userService);
    }
}
