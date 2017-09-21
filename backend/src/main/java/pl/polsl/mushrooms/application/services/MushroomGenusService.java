package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.mushroom.genus.CreateMushroomGenusCommand;
import pl.polsl.mushrooms.application.commands.mushroom.genus.DeleteMushroomGenusCommand;
import pl.polsl.mushrooms.application.commands.mushroom.genus.UpdateMushroomGenusCommand;
import pl.polsl.mushrooms.infrastructure.dto.MushroomGenusDto;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public interface MushroomGenusService {

    /**
     * Creates new mushroom genus
     * @param command
     * @return Id of the mushroom genus
     */
    long handle(CreateMushroomGenusCommand command);

    /**
     * Updates the mushroom genus
     * @param command
     * @return Updated mushroom genus
     */
    MushroomGenusDto handle(UpdateMushroomGenusCommand command);

    /**
     * Delete the mushroom genus
     * @param command
     */
    void handle(DeleteMushroomGenusCommand command);
}
