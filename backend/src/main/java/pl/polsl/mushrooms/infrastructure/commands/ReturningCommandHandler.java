package pl.polsl.mushrooms.infrastructure.commands;

import pl.polsl.mushrooms.application.commands.ReturningCommand;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
@FunctionalInterface
public interface ReturningCommandHandler<R, C extends ReturningCommand<R>> {
    R handle(C command);
}
