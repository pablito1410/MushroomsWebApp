package pl.polsl.mushrooms.application.commands;

import pl.polsl.mushrooms.application.enums.UserRole;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class CreateUserCommand implements ReturningCommand<UUID> {

    protected String username;

    protected String email;
    protected String password;

    @NotNull
    private UserRole role = UserRole.USER;


    private CreateUserCommand() { }

    public CreateUserCommand(String username, String email, String password) {
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
