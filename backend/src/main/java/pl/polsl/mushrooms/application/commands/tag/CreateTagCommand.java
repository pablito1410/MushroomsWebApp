package pl.polsl.mushrooms.application.commands.tag;

import pl.polsl.mushrooms.application.commands.ReturningCommand;

/**
 * Created by pawel_zaqkxkn on 17.07.2017.
 */
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
