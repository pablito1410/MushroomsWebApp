package pl.polsl.mushrooms.application.commands.user;

import pl.polsl.mushrooms.application.commands.VoidCommand;
import pl.polsl.mushrooms.application.enums.Gender;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class CreateCommand implements VoidCommand {

    @NotNull
    protected String username;

    @NotNull
    protected String email;

    @NotNull
    protected String password;

    private String firstName;
    private String lastName;
    private Date birthDate;
    private Gender gender;


    private CreateCommand() { }

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
