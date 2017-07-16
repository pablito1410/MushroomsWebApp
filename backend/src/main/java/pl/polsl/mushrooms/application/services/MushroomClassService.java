package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.mushroom.clazz.CreateMushroomClassCommand;
import pl.polsl.mushrooms.application.commands.mushroom.clazz.DeleteMushroomClassCommand;
import pl.polsl.mushrooms.application.commands.mushroom.clazz.UpdateMushroomClassCommand;
import pl.polsl.mushrooms.infrastructure.dto.MushroomClassDto;

/**
 * Created by pawel_zaqkxkn on 04.07.2017.
 */
public interface MushroomClassService {

    long handle(CreateMushroomClassCommand command);

    MushroomClassDto handle(UpdateMushroomClassCommand command);

    void handle(DeleteMushroomClassCommand command);
}
