package pl.polsl.mushrooms.application.commands.mushroom.genus;

import pl.polsl.mushrooms.application.commands.VoidCommand;
import javax.validation.constraints.NotNull;

public class DeleteMushroomGenusCommand implements VoidCommand {

    @NotNull
    private Long id;

    public DeleteMushroomGenusCommand() { }

    public DeleteMushroomGenusCommand(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
