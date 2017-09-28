package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MushroomOrderDto {

    private long id;
    private String name;
    private MushroomClassDto mushroomClass;
    private long mushroomClassId;
}
