package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.infrastructure.dto.TagDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 17.07.2017.
 */
public interface TagProjectionDao extends ProjectionDao<TagDto> {

    Set<TagDto> findByDiscoveryId(final long discoveryId);

    Set<TagDto> findAll(long userId);
}
