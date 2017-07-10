package pl.polsl.mushrooms.application.commands.comment;

import pl.polsl.mushrooms.application.commands.ReturningCommand;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class CreateCommentCommand implements ReturningCommand<Long> {

    private String userName;

    @NotNull
    private String contents;
    @NotNull
    private long targetId;
    @NotNull
    private LocalDateTime dateTime;

    protected CreateCommentCommand() { }

    public String getContents() {
        return contents;
    }

    public long getTargetId() {
        return targetId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
