package pl.polsl.mushrooms.application.commands.mushroom.family;

import org.hibernate.validator.constraints.NotEmpty;
import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.infrastructure.dto.MushroomFamilyDto;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public class UpdateMushroomFamilyCommand implements ReturningCommand<MushroomFamilyDto> {

    @NotNull
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    protected UpdateMushroomFamilyCommand() { }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
