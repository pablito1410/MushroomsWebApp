package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 15.05.2017.
 */
public interface DiscoveryProjectionDao extends ProjectionDao<DiscoveryDto> {


    Set<DiscoveryDto> search(final String userName, String value, boolean my, boolean friends, boolean isPublic);
}
