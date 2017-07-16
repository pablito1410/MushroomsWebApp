package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.mushroom.family.CreateMushroomFamilyCommand;
import pl.polsl.mushrooms.application.commands.mushroom.family.DeleteMushroomFamilyCommand;
import pl.polsl.mushrooms.application.commands.mushroom.family.UpdateMushroomFamilyCommand;
import pl.polsl.mushrooms.infrastructure.dto.MushroomFamilyDto;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public interface MushroomFamilyService {

    long handle(CreateMushroomFamilyCommand command);

    MushroomFamilyDto handle(UpdateMushroomFamilyCommand command);

    void handle(DeleteMushroomFamilyCommand command);
}
