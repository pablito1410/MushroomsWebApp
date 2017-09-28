package pl.polsl.mushrooms.application.commands.mushroom.genus;

import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.infrastructure.dto.MushroomGenusDto;
import javax.validation.constraints.NotNull;

public class UpdateMushroomGenusCommand implements ReturningCommand<MushroomGenusDto> {

    @NotNull
    private Long id;
    private String name;

    protected UpdateMushroomGenusCommand() { }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
