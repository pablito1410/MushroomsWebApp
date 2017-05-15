package pl.polsl.mushrooms.application.commands.user;

import pl.polsl.mushrooms.application.commands.VoidCommand;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class DeleteUserCommand implements VoidCommand {


    private UUID id;
    private String password;

    private DeleteUserCommand() { }

    public UUID getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
