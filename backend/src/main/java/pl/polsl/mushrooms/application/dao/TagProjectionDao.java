package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 17.07.2017.
 */
public interface TagProjectionDao extends ProjectionDao<TagDto> {

    Set<TagDto> findAll(long userId);

    DiscoveryDto findDiscovery(long tagId);
}
