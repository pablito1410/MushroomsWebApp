package pl.polsl.mushrooms.application.commands;

/**
 * Created by pawel_zaqkxkn on 30.03.2017.
 */
public class LoginCommand implements ReturningCommand<String> {

    private String email;
    private String passwordHash;

    private LoginCommand() { }

    public LoginCommand(String email, String passwordHash) {
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
