package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.mushroom.genus.CreateMushroomGenusCommand;
import pl.polsl.mushrooms.application.commands.mushroom.genus.DeleteMushroomGenusCommand;
import pl.polsl.mushrooms.application.commands.mushroom.genus.UpdateMushroomGenusCommand;
import pl.polsl.mushrooms.infrastructure.dto.MushroomGenusDto;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public interface MushroomGenusService {

    long handle(CreateMushroomGenusCommand command);

    MushroomGenusDto handle(UpdateMushroomGenusCommand command);

    void handle(DeleteMushroomGenusCommand command);
}
