package pl.polsl.mushrooms.application.commands.mushroom.species;

import org.hibernate.validator.constraints.NotEmpty;
import pl.polsl.mushrooms.application.commands.ReturningCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 17.07.2017.
 */
public class CreateMushroomSpeciesCommand implements ReturningCommand<Long> {

    @NotNull
    private Long mushroomGenusId;

    @NotNull
    @NotEmpty
    private String name;

    private byte[] examplePhoto;

    protected CreateMushroomSpeciesCommand() { }

    public Long getMushroomGenusId() {
        return mushroomGenusId;
    }

    public String getName() {
        return name;
    }

    public byte[] getExamplePhoto() {
        return examplePhoto;
    }
}
