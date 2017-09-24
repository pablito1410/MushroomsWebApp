package pl.polsl.mushrooms.infrastructure.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.mushrooms.infrastructure.tools.serializers.LocalDateTimeSerializer;

import java.time.LocalDateTime;

/**
 * Created by pawel_zaqkxkn on 21.06.2017.
 */
@Getter
@Setter
public class DiscoveryDto {

    protected long id;
    private double coordinateX;
    private double coordinateY;
    private byte[] photo;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTime;
    private boolean isPublic;

    private long tripId;
    private MushroomSpeciesDto mushroomSpecies;
    private long mushroomSpeciesId;
    private long mushroomerId;
}
