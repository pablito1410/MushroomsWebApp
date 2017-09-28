package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MushroomGenusDto {

    private long id;
    private String name;
    private MushroomFamilyDto family;
    private long familyId;
}
