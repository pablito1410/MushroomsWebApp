package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.CommentDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public interface CommentProjectionService {

    CommentDto findOne(long id);

    Set<CommentDto> findAll(String userName);
}
