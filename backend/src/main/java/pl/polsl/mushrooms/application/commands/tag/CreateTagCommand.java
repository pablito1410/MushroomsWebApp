package pl.polsl.mushrooms.application.commands.tag;

import pl.polsl.mushrooms.application.commands.ReturningCommand;

public class CreateTagCommand implements ReturningCommand<Long> {


    private String userName;
    private Long discoveryId;
    private String name;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getDiscoveryId() {
        return discoveryId;
    }

    public String getName() {
        return name;
    }
}
