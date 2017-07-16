package pl.polsl.mushrooms.application.commands.mushroom.order;

import org.hibernate.validator.constraints.NotEmpty;
import pl.polsl.mushrooms.application.commands.ReturningCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public class CreateMushroomOrderCommand implements ReturningCommand<Long> {

    @NotNull
    private Long mushroomClassId;

    @NotNull
    @NotEmpty
    private String name;

    protected CreateMushroomOrderCommand() { }

    public Long getMushroomClassId() {
        return mushroomClassId;
    }

    public String getName() {
        return name;
    }
}
