package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.mushroom.order.CreateMushroomOrderCommand;
import pl.polsl.mushrooms.application.commands.mushroom.order.DeleteMushroomOrderCommand;
import pl.polsl.mushrooms.application.commands.mushroom.order.UpdateMushroomOrderCommand;
import pl.polsl.mushrooms.infrastructure.dto.MushroomOrderDto;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
public interface MushroomOrderService {

    /**
     * Creates new mushroom order
     * @param command
     * @return Id of mushroom order
     */
    long handle(CreateMushroomOrderCommand command);

    /**
     * Updates the mushroom order
     * @param command
     * @return Updated mushroom order
     */
    MushroomOrderDto handle(UpdateMushroomOrderCommand command);

    /**
     * Deletes mushroom order
     * @param command
     */
    void handle(DeleteMushroomOrderCommand command);
}
