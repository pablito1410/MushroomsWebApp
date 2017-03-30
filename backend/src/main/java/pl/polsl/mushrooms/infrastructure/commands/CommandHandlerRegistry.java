package pl.polsl.mushrooms.infrastructure.commands;

import pl.polsl.mushrooms.application.commands.ReturningCommand;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Verify.verifyNotNull;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class CommandHandlerRegistry {

    private final Map<Class<?>, ReturningCommandHandler> handlers = new HashMap<>();

    public <R, C extends ReturningCommand<R>> void register(ReturningCommandHandler<R, C> handler, Class<C> cClass) {
        verifyNotNull(handler);
        verifyNotNull(cClass);
        handlers.put(cClass, handler);
    }

    public <R, C extends ReturningCommand<R>> ReturningCommandHandler<R, C> get(C command) {
        verifyNotNull(command);

        final ReturningCommandHandler handler = handlers.get(command.getClass());

        if (handler == null) {
            throw new RuntimeException("No handler registered for command: " + command.getClass().getSimpleName());
        } else {
            return handler;
        }
    }

}
