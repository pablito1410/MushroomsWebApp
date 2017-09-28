package pl.polsl.mushrooms.application.services.projections;

import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;

import java.util.Set;


public interface TagProjectionService {

    Set<TagDto> findAll(String userName);

    TagDto findOne(long id);

    Set<TagDto> search(String value);

    DiscoveryDto findDiscovery(long tagId);
}