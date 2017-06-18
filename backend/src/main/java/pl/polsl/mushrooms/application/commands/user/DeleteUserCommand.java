package pl.polsl.mushrooms.application.commands.user;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class DeleteUserCommand implements VoidCommand {

    @NotNull
    private long[] ids;

    @NotNull
    private String adminPassword;

    private DeleteUserCommand() { }

    public long[] getIds() {
        return ids;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
}
