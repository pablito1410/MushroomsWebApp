package pl.polsl.mushrooms.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

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
    private LocalDateTime dateTime;
    private long tripId;
    private MushroomSpeciesDto mushroomSpecies;
    private long mushroomerId;
    private Set<ScoreDto> scores;
    private Set<TagDto> tags;
    private Set<CommentDto> comments;
}
