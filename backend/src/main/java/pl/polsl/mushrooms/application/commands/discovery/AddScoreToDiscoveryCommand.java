package pl.polsl.mushrooms.application.commands.discovery;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 20.06.2017.
 */
public class AddScoreToDiscoveryCommand implements VoidCommand {

    private String userName;

    @NotNull
    private long discoveryId;

    @NotNull
    private int score;

    protected AddScoreToDiscoveryCommand() { }

    public long getDiscoveryId() {
        return discoveryId;
    }

    public int getScore() {
        return score;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
