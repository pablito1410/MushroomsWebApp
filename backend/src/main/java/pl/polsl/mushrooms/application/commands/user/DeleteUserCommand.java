package pl.polsl.mushrooms.application.commands.user;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class DeleteUserCommand implements VoidCommand {

    @NotNull
    private long id;

    @NotNull
    private String password;

    private DeleteUserCommand() { }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
