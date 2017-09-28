package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;
import pl.polsl.mushrooms.infrastructure.commands.CommandGatewayImpl;
import pl.polsl.mushrooms.infrastructure.commands.CommandHandlerRegistry;


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
