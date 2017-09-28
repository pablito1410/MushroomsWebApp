package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MushroomFamilyDto {

    private long id;
    private String name;
    private MushroomOrderDto order;
    private long orderId;
}
