package pl.polsl.mushrooms.application.commands.mushroom.genus;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public class DeleteMushroomGenusCommand implements VoidCommand {

    @NotNull
    private Long id;

    protected DeleteMushroomGenusCommand() { }

    public Long getId() {
        return id;
    }
}
