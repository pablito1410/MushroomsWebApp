package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;
import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.application.enums.MushroomerLevel;
import pl.polsl.mushrooms.application.enums.UserRole;

import java.util.Date;

/**
 * Created by pawel_zaqkxkn on 21.06.2017.
 */
@Getter
@Setter
public class MushroomerDto extends UserDto {

    private String firstName;
    private String lastName;
    private Date birthDate;
    private Gender gender;
    private MushroomerLevel level;
    private String country;
    private String city;
    private byte[] photo;
    private UserRole role;

}
