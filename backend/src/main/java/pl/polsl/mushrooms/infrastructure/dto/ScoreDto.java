package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ScoreDto {

    private long id;
    private int value;
    private Long discoveryId;
    private Long mushroomerId;
}
