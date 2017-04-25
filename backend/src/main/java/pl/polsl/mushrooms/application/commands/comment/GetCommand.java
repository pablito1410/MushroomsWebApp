package pl.polsl.mushrooms.application.commands.comment;

import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.application.model.Comment;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class GetCommand implements ReturningCommand<Comment> {

    private UUID id;

    protected GetCommand() { }

    public GetCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
