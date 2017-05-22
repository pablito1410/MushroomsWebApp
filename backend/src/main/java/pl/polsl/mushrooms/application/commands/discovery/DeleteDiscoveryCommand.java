package pl.polsl.mushrooms.application.commands.discovery;

import pl.polsl.mushrooms.application.commands.VoidCommand;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class DeleteDiscoveryCommand implements VoidCommand {

    private long id;

    protected DeleteDiscoveryCommand() { }

    public DeleteDiscoveryCommand(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
