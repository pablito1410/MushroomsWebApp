package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.polsl.mushrooms.application.commands.CreateUserCommand;
import pl.polsl.mushrooms.application.dao.UserDao;
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
        };

    }

    @Bean
    public UserService userService(UserDao repo) {
        return new UserServiceImpl(repo);
    }

}
