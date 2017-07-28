package pl.polsl.mushrooms.application.commands.mushroom.order;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
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
