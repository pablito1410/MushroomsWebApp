package pl.polsl.mushrooms.application.commands.mushroom.species;

import org.hibernate.validator.constraints.NotEmpty;
import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.infrastructure.dto.MushroomSpeciesDto;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 17.07.2017.
 */
public class UpdateMushroomSpeciesCommand implements ReturningCommand<MushroomSpeciesDto> {

    @NotNull
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Long mushroomGenusId;

    private byte[] examplePhoto;

    protected UpdateMushroomSpeciesCommand() { }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getMushroomGenusId() {
        return mushroomGenusId;
    }

    public byte[] getExamplePhoto() {
        return examplePhoto;
    }
}
