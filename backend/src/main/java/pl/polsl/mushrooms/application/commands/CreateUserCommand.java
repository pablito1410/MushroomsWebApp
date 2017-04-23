package pl.polsl.mushrooms.application.commands;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.polsl.mushrooms.application.enums.Gender;
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

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private Gender gender;

    @NotNull
    private UserRole role = UserRole.USER;


    private CreateUserCommand() { }

    public CreateUserCommand(String username, String email, String password, Gender gender) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
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

    public Gender getGender() {
        return gender;
    }

    public UserRole getRole() {
        return role;
    }
}
