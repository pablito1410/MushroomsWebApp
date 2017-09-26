package pl.polsl.mushrooms.application.commands.user;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class DeleteUsersCommand implements VoidCommand {

    private String userName;

    @NotNull
    private long[] ids;

//    @NotNull
//    private String adminPassword;

    protected DeleteUsersCommand() { }

    public long[] getIds() {
        return ids;
    }

//    public String getAdminPassword() {
//        return adminPassword;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
