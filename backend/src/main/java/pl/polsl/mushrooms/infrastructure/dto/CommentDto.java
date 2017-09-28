package pl.polsl.mushrooms.infrastructure.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.mushrooms.infrastructure.tools.serializers.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
public class CommentDto {

    private Long id;
    private String content;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTime;

    private Long discoveryId;
    private Long targetId;
    private MushroomerDto user;
    private Set<CommentDto> answers;
}
