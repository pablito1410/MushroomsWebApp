package pl.polsl.mushrooms.infrastructure.dao;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.NotificationProjectionDao;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.Notification;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.NotificationDto;
import pl.polsl.mushrooms.infrastructure.repositories.NotificationRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * Created by chythe on 2017-07-02.
 */
@Repository
public class NotificationProjectionDaoImpl implements NotificationProjectionDao {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public NotificationProjectionDaoImpl(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public NotificationDto findOne(long notificationId) {
        final Optional<Notification> notification = Optional.ofNullable((Notification)notificationRepository.findOne(notificationId));
        if (notification.isPresent()) {
            return mapNotificationToDto(notification.get(), NotificationDto.class);
        } else {
            throw new EntityNotFoundException("Notification not found");
        }
    }

    @Override
    public Set<NotificationDto> findAll(String userName) {
        final User user = Optional.ofNullable(
                userRepository.findOneByUsername(userName))
                .orElseThrow(EntityNotFoundException::new);
        if (user instanceof Mushroomer) {
            final Set<Notification> notifications = ((Mushroomer)user).getNotifications();
            return modelMapper.map(notifications, new TypeToken<Set<NotificationDto>>() {}.getType());
        } else {
            throw new IllegalStateException("User is not instance of Mushroomer");
        }
    }

    private NotificationDto mapNotificationToDto(final Object notification, Type destinationType) {
        Objects.requireNonNull(notification);
        return modelMapper.map(notification, NotificationDto.class);
    }
}
