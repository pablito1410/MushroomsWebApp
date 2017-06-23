package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by pawel_zaqkxkn on 21.06.2017.
 */
@Getter
@Setter
public class ScoreDto {

    private long id;
    private int value;
    private Long discoveryId;
    private Long mushroomerId;
}
