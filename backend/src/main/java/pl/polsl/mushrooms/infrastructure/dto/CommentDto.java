package pl.polsl.mushrooms.infrastructure.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.mushrooms.infrastructure.tools.serializers.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 21.06.2017.
 */
@Getter
@Setter
public class CommentDto {

    private String content;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTime;

    private Long discoveryId;
    private Long targetId;
    private Long commentId;
    private MushroomerDto user;
    private Set<CommentDto> answers;
}
