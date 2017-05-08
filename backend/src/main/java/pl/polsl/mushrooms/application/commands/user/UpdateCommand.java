package pl.polsl.mushrooms.application.commands.user;

import pl.polsl.mushrooms.application.commands.VoidCommand;
import pl.polsl.mushrooms.application.enums.Gender;

import java.util.Date;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class UpdateCommand implements VoidCommand {

    private UUID userId;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Gender gender;

    private UpdateCommand() { }

    public UUID getUserId() {
        return userId;
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
