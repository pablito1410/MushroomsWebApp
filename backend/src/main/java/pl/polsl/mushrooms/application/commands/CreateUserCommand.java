package pl.polsl.mushrooms.application.commands;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.application.enums.UserRole;
import pl.polsl.mushrooms.application.model.User;

import javax.validation.constraints.NotNull;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class CreateUserCommand implements ReturningCommand<User> {

    private String email;
    private String password;
    private String passwordRepeated;

    private String nick;
    private int age;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private Gender gender;

    @NotNull
    private UserRole role = UserRole.USER;


    private CreateUserCommand() { }

    public CreateUserCommand(String email, String password, String passwordRepeated, String nick, int age, Gender gender) {
        this.email = email;
        this.password = password;
        this.passwordRepeated = passwordRepeated;
        this.nick = nick;
        this.age = age;
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNick() {
        return nick;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public UserRole getRole() {
        return role;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }
}
