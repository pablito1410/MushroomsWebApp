package pl.polsl.mushrooms.application.commands.user;

import pl.polsl.mushrooms.application.commands.VoidCommand;
import pl.polsl.mushrooms.application.enums.UserRole;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class CreateCommand implements VoidCommand {

    protected String username;

    protected String email;
    protected String password;

    @NotNull
    private UserRole role = UserRole.USER;


    private CreateCommand() { }

    public CreateCommand(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }
}
