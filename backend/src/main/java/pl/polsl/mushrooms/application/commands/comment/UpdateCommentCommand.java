package pl.polsl.mushrooms.application.commands.comment;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class UpdateCommentCommand implements VoidCommand {

    @NotNull
    private long id;
    @NotNull
    private String contents;

    protected UpdateCommentCommand() { }

    public long getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }
}
