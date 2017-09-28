package pl.polsl.mushrooms.application.commands.mushroom.family;

import org.hibernate.validator.constraints.NotEmpty;
import pl.polsl.mushrooms.application.commands.ReturningCommand;
import javax.validation.constraints.NotNull;

public class CreateMushroomFamilyCommand implements ReturningCommand<Long> {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Long mushroomOrderId;

    protected CreateMushroomFamilyCommand() { }

    public String getName() {
        return name;
    }

    public Long getMushroomOrderId() {
        return mushroomOrderId;
    }
}
