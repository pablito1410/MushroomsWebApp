package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.polsl.mushrooms.application.user.UserRepository;
import pl.polsl.mushrooms.application.user.UserService;
import pl.polsl.mushrooms.application.user.UserServiceImpl;
import pl.polsl.mushrooms.application.user.command.CreateUserCommand;
import pl.polsl.mushrooms.infrastructure.command.CommandHandlerRegistry;

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
    public UserService userService(UserRepository repo) {
        return new UserServiceImpl(repo);
    }

}
