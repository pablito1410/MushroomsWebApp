package pl.polsl.mushrooms.application.commands.mushroom.order;

import org.hibernate.validator.constraints.NotEmpty;
import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.infrastructure.dto.MushroomOrderDto;
import javax.validation.constraints.NotNull;

public class UpdateMushroomOrderCommand implements ReturningCommand<MushroomOrderDto> {

    @NotNull
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    protected UpdateMushroomOrderCommand() { }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
