package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {

    protected long id;
    protected String username;
    protected String email;

}
