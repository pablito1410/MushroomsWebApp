package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.discovery.CreateDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateDiscoveryCommand;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public interface DiscoveryService {

    /**
     * Create a discovery
     * @param command
     * @return Id of created discovery
     */
    long handle(CreateDiscoveryCommand command);

    /**
     * Updates the discovery
     * @param command
     */
    void handle(UpdateDiscoveryCommand command);

    /**
     * Deletes the discovery
     * @param command
     */
    void handle(DeleteDiscoveryCommand command);

}
