package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.discovery.CreateCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteCommand;
import pl.polsl.mushrooms.application.commands.discovery.GetCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateCommand;
import pl.polsl.mushrooms.application.model.Discovery;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public interface DiscoveryService {

    void handle(CreateCommand command);

    Discovery handle(GetCommand command);

    void handle(UpdateCommand command);

    void handle(DeleteCommand command);
}
