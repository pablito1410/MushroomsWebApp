package pl.polsl.mushrooms.application.commands.comment;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class DeleteCommentCommand implements VoidCommand {

    private UUID id;

    protected DeleteCommentCommand() { }

    public DeleteCommentCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
