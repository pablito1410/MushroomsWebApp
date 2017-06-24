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
public class CommentDto extends CommentableDto{

    private String content;
    private LocalDateTime dateTime;
    private Long targetId;
    private UserDto user;
    private Set<CommentDto> answers;
}
