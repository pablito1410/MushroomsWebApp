package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.mushroom.clazz.CreateMushroomClassCommand;
import pl.polsl.mushrooms.application.commands.mushroom.clazz.DeleteMushroomClassCommand;
import pl.polsl.mushrooms.application.commands.mushroom.clazz.UpdateMushroomClassCommand;
import pl.polsl.mushrooms.infrastructure.dto.MushroomClassDto;

/**
 * Created by pawel_zaqkxkn on 04.07.2017.
 */
public interface MushroomClassService {

    /**
     * Adds the new mushroom class
     * @param command
     * @return If of created mushroom class
     */
    long handle(CreateMushroomClassCommand command);

    /**
     * Updates the new mushroom class
     * @param command
     * @return Updated mushroom class
     */
    MushroomClassDto handle(UpdateMushroomClassCommand command);

    /**
     * Deletes the mushroom class
     * @param command
     */
    void handle(DeleteMushroomClassCommand command);
}
