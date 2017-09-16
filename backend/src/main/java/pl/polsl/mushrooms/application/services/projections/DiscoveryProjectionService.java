package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.CommentDto;
import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public interface DiscoveryProjectionService {

    DiscoveryDto findOne(long id);

    Set<DiscoveryDto> findAll(String userName);

    Set<DiscoveryDto> search(final String userName, String value, boolean my, boolean friends, boolean isPublic);

    Set<TagDto> findTags(long id);

    Set<CommentDto> findComments(long id);
}
