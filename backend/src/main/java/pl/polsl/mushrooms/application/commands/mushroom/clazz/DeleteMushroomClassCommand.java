package pl.polsl.mushrooms.application.commands.mushroom.clazz;

import pl.polsl.mushrooms.application.commands.VoidCommand;
import javax.validation.constraints.NotNull;

public class DeleteMushroomClassCommand implements VoidCommand {

    @NotNull
    private Long id;

    public DeleteMushroomClassCommand() { }

    public DeleteMushroomClassCommand(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
