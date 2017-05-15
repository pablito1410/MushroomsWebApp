package pl.polsl.mushrooms.application.commands.comment;

import pl.polsl.mushrooms.application.commands.ReturningCommand;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class CreateCommentCommand implements ReturningCommand<UUID> {

    private UUID userId;
    private String contents;
    private UUID targetId;
    private LocalDateTime dateTime;

    protected CreateCommentCommand() { }

    public UUID getUserId() {
        return userId;
    }

    public String getContents() {
        return contents;
    }

    public UUID getTargetId() {
        return targetId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
