package pl.polsl.mushrooms.infrastructure.command;

import pl.polsl.mushrooms.application.ports.ReturningCommand;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface CommandGateway {

    <R> R dispatch(ReturningCommand<R> command);


}
