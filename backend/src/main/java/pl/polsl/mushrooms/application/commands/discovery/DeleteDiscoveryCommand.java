package pl.polsl.mushrooms.application.commands.discovery;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class DeleteDiscoveryCommand implements VoidCommand {

    private UUID id;

    protected DeleteDiscoveryCommand() { }

    public DeleteDiscoveryCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
