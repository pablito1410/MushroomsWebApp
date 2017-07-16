package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.mushroom.order.CreateMushroomOrderCommand;
import pl.polsl.mushrooms.application.commands.mushroom.order.DeleteMushroomOrderCommand;
import pl.polsl.mushrooms.application.commands.mushroom.order.UpdateMushroomOrderCommand;
import pl.polsl.mushrooms.infrastructure.dto.MushroomOrderDto;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public interface MushroomOrderService {

    long handle(CreateMushroomOrderCommand command);

    MushroomOrderDto handle(UpdateMushroomOrderCommand command);

    void handle(DeleteMushroomOrderCommand command);
}
