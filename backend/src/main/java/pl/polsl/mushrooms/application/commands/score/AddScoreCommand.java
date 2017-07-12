package pl.polsl.mushrooms.application.commands.score;

import pl.polsl.mushrooms.application.commands.ReturningCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */
public class AddScoreCommand implements ReturningCommand<Long>{

    private String userName;

    @NotNull
    private Long discoveryId;

    @NotNull
    private Integer value;

    protected AddScoreCommand() { }

    public long getDiscoveryId() {
        return discoveryId.longValue();
    }

    public int getValue() {
        return value.intValue();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
