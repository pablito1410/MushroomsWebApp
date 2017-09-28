package pl.polsl.mushrooms.application.commands.mushroom.order;

import pl.polsl.mushrooms.application.commands.VoidCommand;
import javax.validation.constraints.NotNull;

public class DeleteMushroomOrderCommand implements VoidCommand {

    @NotNull
    private Long id;

    public DeleteMushroomOrderCommand() { }

    public DeleteMushroomOrderCommand(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
