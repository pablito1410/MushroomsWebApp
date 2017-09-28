package pl.polsl.mushrooms.infrastructure.commands;

import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.application.commands.VoidCommand;


public interface CommandGateway {

    <R> R dispatch(ReturningCommand<R> command);

    void dispatch(VoidCommand command);


}
