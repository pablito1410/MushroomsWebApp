package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.mushroom.family.CreateMushroomFamilyCommand;
import pl.polsl.mushrooms.application.commands.mushroom.family.DeleteMushroomFamilyCommand;
import pl.polsl.mushrooms.application.commands.mushroom.family.UpdateMushroomFamilyCommand;
import pl.polsl.mushrooms.infrastructure.dto.MushroomFamilyDto;


public interface MushroomFamilyService {

    /**
     * Creates new mushroom family
     * @param command
     * @return Id of the mushroom family
     */
    long handle(CreateMushroomFamilyCommand command);

    /**
     * Updates the mushroom family
     * @param command
     * @return Updated mushroom family
     */
    MushroomFamilyDto handle(UpdateMushroomFamilyCommand command);

    /**
     * Deletes the mushroom family
     * @param command
     */
    void handle(DeleteMushroomFamilyCommand command);
}
