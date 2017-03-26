package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.polsl.mushrooms.infrastructure.command.CommandGateway;
import pl.polsl.mushrooms.infrastructure.command.CommandGatewayImpl;
import pl.polsl.mushrooms.infrastructure.command.CommandHandlerRegistry;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
@Configuration
public class CommandConfig {

    @Bean
    public CommandGateway commandGateway(CommandHandlerRegistry registry) {
        return new CommandGatewayImpl(registry);
    }

    @Bean
    public CommandHandlerRegistry commandHandlerRegistry() {
        return new CommandHandlerRegistry();
    }
}
