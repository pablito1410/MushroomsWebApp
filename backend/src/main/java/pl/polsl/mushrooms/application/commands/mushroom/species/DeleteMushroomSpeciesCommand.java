package pl.polsl.mushrooms.application.commands.mushroom.species;

import pl.polsl.mushrooms.application.commands.VoidCommand;
import javax.validation.constraints.NotNull;

public class DeleteMushroomSpeciesCommand implements VoidCommand {

    @NotNull
    private Long id;

    public DeleteMushroomSpeciesCommand() { }

    public DeleteMushroomSpeciesCommand(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
