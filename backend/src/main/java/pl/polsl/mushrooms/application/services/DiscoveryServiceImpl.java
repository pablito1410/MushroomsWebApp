package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.discovery.CreateCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteCommand;
import pl.polsl.mushrooms.application.commands.discovery.GetCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateCommand;
import pl.polsl.mushrooms.application.model.Discovery;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class DiscoveryServiceImpl implements DiscoveryService {


    @Override
    public void handle(CreateCommand command) {

    }

    @Override
    public Discovery handle(GetCommand command) {
        return null;
    }

    @Override
    public void handle(UpdateCommand command) {

    }

    @Override
    public void handle(DeleteCommand command) {

    }
}
