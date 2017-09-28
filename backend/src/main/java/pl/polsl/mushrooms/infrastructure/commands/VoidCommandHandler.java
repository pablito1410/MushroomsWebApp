package pl.polsl.mushrooms.infrastructure.commands;

import pl.polsl.mushrooms.application.commands.Command;


public interface VoidCommandHandler <C extends Command>{
    void handle(C command);
}
