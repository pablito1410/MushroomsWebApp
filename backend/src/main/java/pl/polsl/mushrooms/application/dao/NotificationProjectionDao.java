package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.infrastructure.dto.NotificationDto;

import java.util.Set;

/**
 * Created by chythe on 2017-07-02.
 */
public interface NotificationProjectionDao extends ProjectionDao<NotificationDto> {

    Set<NotificationDto> findAll(String userName);
}
