package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.CommentDto;

import java.util.Set;


public interface CommentProjectionService {

    CommentDto findOne(long id);

    Set<CommentDto> findAll(String userName);
}
