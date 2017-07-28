package pl.polsl.mushrooms.application.commands.mushroom.family;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public class DeleteMushroomFamilyCommand implements VoidCommand {

    @NotNull
    private Long id;

    public DeleteMushroomFamilyCommand() { }

    public DeleteMushroomFamilyCommand(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
