package pl.polsl.mushrooms.infrastructure.commands;

import pl.polsl.mushrooms.application.commands.ReturningCommand;


@FunctionalInterface
public interface ReturningCommandHandler<R, C extends ReturningCommand<R>> {
    R handle(C command);
}
