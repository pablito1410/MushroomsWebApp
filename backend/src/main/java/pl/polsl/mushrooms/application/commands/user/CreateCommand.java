package pl.polsl.mushrooms.application.commands.user;

import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.application.commands.VoidCommand;
import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.application.model.User;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class CreateCommand implements ReturningCommand<UUID> {

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

    public CreateCommand(String username, String email, String password, String firstName, String lastName, Date birthDate, Gender gender) {
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
