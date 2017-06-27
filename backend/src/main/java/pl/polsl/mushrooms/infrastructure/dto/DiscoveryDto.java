package pl.polsl.mushrooms.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

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
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime dateTime;

    private long tripId;
    private MushroomSpeciesDto mushroomSpecies;
    private long mushroomerId;
}
