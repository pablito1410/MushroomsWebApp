package pl.polsl.mushrooms.infrastructure.commands;

import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.application.commands.VoidCommand;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface CommandGateway {

    <R> R dispatch(ReturningCommand<R> command);

    void dispatch(VoidCommand command);


}
