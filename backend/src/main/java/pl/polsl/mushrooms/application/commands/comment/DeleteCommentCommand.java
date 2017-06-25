package pl.polsl.mushrooms.application.commands.comment;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class DeleteCommentCommand implements VoidCommand {

    @NotNull
    private long id;

    protected DeleteCommentCommand() { }

    public DeleteCommentCommand(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
