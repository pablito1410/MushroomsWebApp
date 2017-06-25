package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 21.06.2017.
 */
@Getter
@Setter
public class MushroomFamilyDto {

    private long id;
    private String name;
    private MushroomOrderDto order;
    private Set<Long> genusesIds;
}
