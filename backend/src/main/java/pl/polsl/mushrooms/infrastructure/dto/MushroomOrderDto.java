package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 21.06.2017.
 */
@Getter
@Setter
public class MushroomOrderDto {

    private long id;
    private String name;
    private MushroomClassDto mushroomClass;
    private Set<Long> familiesIds;
}
