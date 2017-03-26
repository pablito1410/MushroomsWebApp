package pl.polsl.mushrooms.application.user.command;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.polsl.mushrooms.application.ports.ReturningCommand;
import pl.polsl.mushrooms.application.user.defs.Gender;
import pl.polsl.mushrooms.application.user.presentation.UserProfilePresentation;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class CreateUserCommand implements ReturningCommand<UserProfilePresentation> {

    private String email;
    private String password;

    private String nick;
    private int age;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private Gender gender;

    private CreateUserCommand() { }

    public CreateUserCommand(String email, String password, String nick, int age, Gender gender) {
        this.email = email;
        this.password = password;
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
}
