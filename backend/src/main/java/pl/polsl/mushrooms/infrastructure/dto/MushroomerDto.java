package pl.polsl.mushrooms.infrastructure.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.application.enums.MushroomerLevel;
import pl.polsl.mushrooms.application.enums.UserRole;
import pl.polsl.mushrooms.infrastructure.controllers.DateDeserializer;

import java.util.Date;

/**
 * Created by pawel_zaqkxkn on 21.06.2017.
 */
@Getter
@Setter
public class MushroomerDto extends UserDto {

    private String firstName;
    private String lastName;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date birthDate;

    private Gender gender;
    private MushroomerLevel level;
    private String country;
    private String city;
    private byte[] photo;
    private UserRole role;

}
