package pl.polsl.mushrooms.infrastructure.commands;

import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.application.commands.VoidCommand;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Verify.verifyNotNull;


public class CommandHandlerRegistry {

    private final Map<Class<?>, ReturningCommandHandler> returningHandlers = new HashMap<>();
    private final Map<Class<?>, VoidCommandHandler> voidHandlers = new HashMap<>();

    public <R, C extends ReturningCommand<R>> void register(ReturningCommandHandler<R, C> handler, Class<C> cClass) {
        verifyNotNull(handler);
        verifyNotNull(cClass);
        returningHandlers.put(cClass, handler);
    }

    public <R, C extends ReturningCommand<R>> ReturningCommandHandler<R, C> get(C command) {
        verifyNotNull(command);

        final ReturningCommandHandler handler = returningHandlers.get(command.getClass());

        if (handler == null) {
            throw new RuntimeException("No handler registered for command: " + command.getClass().getSimpleName());
        } else {
            return handler;
        }
    }

    public <C extends VoidCommand> void register(VoidCommandHandler<C> handler, Class<C> cClass) {
        verifyNotNull(handler);
        verifyNotNull(cClass);
        voidHandlers.put(cClass, handler);
    }

    public <C extends VoidCommand> VoidCommandHandler<C> get(C command) {
        verifyNotNull(command);

        final VoidCommandHandler handler = voidHandlers.get(command.getClass());

        if (handler == null) {
            throw new RuntimeException("No handler registered for command: " + command.getClass().getSimpleName());
        } else {
            return handler;
        }
    }

}
