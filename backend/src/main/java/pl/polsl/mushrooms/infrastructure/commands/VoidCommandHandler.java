package pl.polsl.mushrooms.infrastructure.commands;

import pl.polsl.mushrooms.application.commands.Command;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public interface VoidCommandHandler <C extends Command>{
    void handle(C command);
}
