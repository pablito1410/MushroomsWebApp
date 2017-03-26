package pl.polsl.mushrooms.infrastructure.command;

import pl.polsl.mushrooms.application.ports.ReturningCommand;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class CommandGatewayImpl implements CommandGateway {


    private final CommandHandlerRegistry registry;

    public CommandGatewayImpl(CommandHandlerRegistry registry) {

        this.registry = registry;
    }

    @Override
    public <R> R dispatch(ReturningCommand<R> command) {
        return registry.get(command).handle(command);
    }
}
