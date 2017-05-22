package pl.polsl.mushrooms.application.commands.comment;

import pl.polsl.mushrooms.application.commands.ReturningCommand;

import java.time.LocalDateTime;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class CreateCommentCommand implements ReturningCommand<Long> {

    private long userId;
    private String contents;
    private long targetId;
    private LocalDateTime dateTime;

    protected CreateCommentCommand() { }

    public long getUserId() {
        return userId;
    }

    public String getContents() {
        return contents;
    }

    public long getTargetId() {
        return targetId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
