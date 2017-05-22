package pl.polsl.mushrooms.application.commands.user;

import pl.polsl.mushrooms.application.commands.VoidCommand;
import pl.polsl.mushrooms.application.enums.Gender;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class UpdateUserCommand implements VoidCommand {

    @NotNull
    private long id;

    @NotNull
    private String username;

    @NotNull
    private String email;


    private String firstName;
    private String lastName;
    private Date birthDate;
    private Gender gender;

    private UpdateUserCommand() { }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
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
