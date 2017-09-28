package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.infrastructure.dto.CommentDto;
import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;
import java.util.Set;

public interface DiscoveryProjectionDao extends ProjectionDao<DiscoveryDto> {


    Set<DiscoveryDto> search(final String userName, String value, boolean my, boolean friends, boolean isPublic);

    Set<TagDto> findTags(long discoveryId);

    Set<CommentDto> findComments(long id);
}
