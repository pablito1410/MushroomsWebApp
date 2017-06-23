package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by pawel_zaqkxkn on 21.06.2017.
 */
@Getter
@Setter
public class TagDto {

    private long id;
    private String name;
    private Long discoveryId;
}
