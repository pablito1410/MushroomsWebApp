package pl.polsl.mushrooms.application.commands.score;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */
public class AddScoreCommand implements VoidCommand{

    @NotNull
    private long discoveryId;
    private int value;

    private LocalDateTime dateTime;

    protected AddScoreCommand() { }

    public long getDiscoveryId() {
        return discoveryId;
    }

    public int getValue() {
        return value;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
