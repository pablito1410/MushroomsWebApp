package pl.polsl.mushrooms.application.commands.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class UpdateUserCommand implements ReturningCommand<UserDto>{

    @NotNull
    private String username;

    @NotNull
    private String email;


    private String firstName;
    private String lastName;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthDate;
    private Gender gender;
    private String city;
    private String country;

    private UpdateUserCommand() { }

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

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
