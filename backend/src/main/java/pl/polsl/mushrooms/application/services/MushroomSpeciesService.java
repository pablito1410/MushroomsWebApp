package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.mushroom.species.CreateMushroomSpeciesCommand;
import pl.polsl.mushrooms.application.commands.mushroom.species.DeleteMushroomSpeciesCommand;
import pl.polsl.mushrooms.application.commands.mushroom.species.UpdateMushroomSpeciesCommand;
import pl.polsl.mushrooms.infrastructure.dto.MushroomSpeciesDto;

/**
 * Created by pawel_zaqkxkn on 17.07.2017.
 */
public interface MushroomSpeciesService {

    /**
     * Creates new mushroom species
     * @param command
     * @return
     */
    long handle(CreateMushroomSpeciesCommand command);

    /**
     * Updates the mushroom species
     * @param command
     * @return Updated mushroom species
     */
    MushroomSpeciesDto handle(UpdateMushroomSpeciesCommand command);

    /**
     * Deletes the mushroom species
     * @param command
     */
    void handle(DeleteMushroomSpeciesCommand command);
}
