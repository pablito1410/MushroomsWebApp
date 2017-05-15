package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.discovery.CreateDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateDiscoveryCommand;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public interface DiscoveryService {

    UUID handle(CreateDiscoveryCommand command);

    void handle(UpdateDiscoveryCommand command);

    void handle(DeleteDiscoveryCommand command);
}
