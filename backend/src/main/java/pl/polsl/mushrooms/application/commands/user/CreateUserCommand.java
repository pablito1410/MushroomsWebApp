package pl.polsl.mushrooms.application.commands.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.application.enums.Gender;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class CreateUserCommand implements ReturningCommand<Long> {

    @NotNull
    protected String username;

    @NotNull
    protected String email;

    @NotNull
    protected String password;

    private String firstName;
    private String lastName;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date birthDate;
    private Gender gender;


    private CreateUserCommand() { }

    public CreateUserCommand(String username, String email, String password, String firstName, String lastName, Date birthDate, Gender gender) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }
}
