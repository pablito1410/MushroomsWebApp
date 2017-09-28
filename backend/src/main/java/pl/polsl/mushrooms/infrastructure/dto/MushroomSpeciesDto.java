package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MushroomSpeciesDto {

    private long id;
    private String name;
    private byte[] examplePhoto;
    private MushroomGenusDto genus;
    private long genusId;

}
