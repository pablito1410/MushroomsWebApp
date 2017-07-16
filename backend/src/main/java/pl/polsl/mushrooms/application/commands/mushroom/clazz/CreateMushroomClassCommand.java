package pl.polsl.mushrooms.application.commands.mushroom.clazz;

import org.hibernate.validator.constraints.NotEmpty;
import pl.polsl.mushrooms.application.commands.ReturningCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public class CreateMushroomClassCommand implements ReturningCommand<Long> {

    @NotNull
    @NotEmpty
    private String name;

    protected CreateMushroomClassCommand() { }

    public String getName() {
        return name;
    }
}
