package pl.polsl.mushrooms.infrastructure.dao;

import com.sun.nio.sctp.Notification;
import org.modelmapper.ModelMapper;
import pl.polsl.mushrooms.application.dao.NotificationProjectionDao;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.model.Admin;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.AdminDto;
import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.dto.NotificationDto;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;
import pl.polsl.mushrooms.infrastructure.repositories.NotificationRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * Created by chythe on 2017-07-02.
 */
public class NotificationProjectionDaoImpl implements NotificationProjectionDao {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public NotificationProjectionDaoImpl(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public NotificationDto findOne(long notificationId, ProjectionDao.Projection projection) {
        final Optional<Notification> notification = Optional.ofNullable((Notification)notificationRepository.findOne(notificationId));
        if (notification.isPresent()) {
            return mapNotificationToDto(notification.get());
        } else {
            throw new EntityNotFoundException("User not found");
        }
    }

    @Override
    public Set<NotificationDto> findAll(String userName, ProjectionDao.Projection projection) {
        return null;
    }

    private NotificationDto mapNotificationToDto(final Notification notification) {
        Objects.requireNonNull(notification);

        if (notification instanceof Notification) {
            return modelMapper.map((Notification) notification, NotificationDto.class);
        } else {
            throw new IllegalStateException("Unknown instanceof Notification class - " + notification.getClass());
        }
    }
}
