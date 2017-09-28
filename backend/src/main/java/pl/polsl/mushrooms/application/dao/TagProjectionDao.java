package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;

import java.util.Set;


public interface TagProjectionDao extends ProjectionDao<TagDto> {

    Set<TagDto> findAll(long userId);

    DiscoveryDto findDiscovery(long tagId);
}
