package pl.polsl.mushrooms.application.commands.comment;

import pl.polsl.mushrooms.application.commands.VoidCommand;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
public class UpdateCommentCommand implements VoidCommand {

    private long id;
    private String contents;

    protected UpdateCommentCommand() { }

    public long getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }
}
