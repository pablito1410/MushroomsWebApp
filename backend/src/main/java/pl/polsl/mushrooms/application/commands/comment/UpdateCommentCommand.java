package pl.polsl.mushrooms.application.commands.comment;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

public class UpdateCommentCommand implements VoidCommand {

    private String userName;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}