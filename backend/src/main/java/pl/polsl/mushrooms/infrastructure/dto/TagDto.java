package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TagDto {

    private long id;
    private String name;
    private Long discoveryId;
}
