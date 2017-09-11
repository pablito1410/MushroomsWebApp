package pl.polsl.mushrooms.application.commands.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.polsl.mushrooms.application.commands.ReturningCommand;
import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;
import pl.polsl.mushrooms.infrastructure.tools.deserializers.DateDeserializer;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public class UpdateUserCommand implements ReturningCommand<UserDto>{

    @Transient
    private String currentUserName;

    @NotNull
    private Long id;
    private String username;
    @NotNull
    private String email;


    private String firstName;
    private String lastName;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date birthDate;

    private Gender gender;
    private String city;
    private String country;

    private UpdateUserCommand() { }

    public UpdateUserCommand(String email, String firstName, String lastName, Date birthDate, Gender gender, String city, String country) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
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

    public String getUsername() {
        return username;
    }

    public void setCurrentUserName(final String adminUserName) {
        this.currentUserName = adminUserName;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }
}
