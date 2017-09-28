package pl.polsl.mushrooms.application.commands.tag;

import pl.polsl.mushrooms.application.commands.VoidCommand;

public class DeleteTagCommand implements VoidCommand {

    private final long id;
    private String name;

    private String userName;

    public DeleteTagCommand(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
