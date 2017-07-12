package pl.polsl.mushrooms.application.commands.notification;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by chythe on 2017-07-02.
 */
public class DeleteNotificationCommand implements VoidCommand {

    private String userName;

    @NotNull
    private long id;

    public DeleteNotificationCommand() { }

    public long getNotificationId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
