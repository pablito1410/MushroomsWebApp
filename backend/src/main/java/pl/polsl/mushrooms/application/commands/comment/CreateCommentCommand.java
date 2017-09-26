package pl.polsl.mushrooms.application.commands.comment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.infrastructure.tools.deserializers.LocalDateTimeDeserializer;

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

    @NotNull long discoveryId;

    @NotNull
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
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

    public void setContents(final String contents) {
        this.contents = contents;
    }

    public void setTargetId(final long targetId) {
        this.targetId = targetId;
    }

    public long getDiscoveryId() {
        return discoveryId;
    }

    public  void setDiscoveryId(final long discoveryId) {
        this.discoveryId = discoveryId;
    }

    public void setDateTime(final LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
