package pl.polsl.mushrooms.infrastructure.dao;

import org.springframework.transaction.annotation.Transactional;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 01.05.2017.
 */
public class UserProjectionDaoImpl implements UserProjectionDao {

    private final UserRepository userRepository;
    private final EntityMapper entityMapper;

    public UserProjectionDaoImpl(
            final UserRepository userRepository, EntityMapper entityMapper) {
        this.userRepository = userRepository;
        this.entityMapper = entityMapper;
    }


    @Transactional(readOnly = true)
    @Override
    public UserDto findOneByUsername(String username) {
        final Optional<User> user = Optional.ofNullable(userRepository.findOneByUsername(username));
        if (user.isPresent()) {
            return entityMapper.map(user.get());
        } else {
            throw new EntityNotFoundException("User not found");
        }
    }

    @Override
    public UserDto findOne(long id) {
        final Optional<User> user = Optional.ofNullable(userRepository.findOne(id));
        if (user.isPresent()) {
            return entityMapper.map(user.get());
        } else {
            throw new EntityNotFoundException("User not found");
        }
    }


    @Override
    public long getId(String username) {
        final User user = Optional.ofNullable(
                userRepository.findOneByUsername(username))
                .orElseThrow(EntityNotFoundException::new);

        return user.getId();
    }

    @Override
    public Set<UserDto> findAll(long id) {
        final User user = Optional.ofNullable(
                userRepository.findOne(id))
                .orElseThrow(EntityNotFoundException::new);

        switch(user.getRole()) {
            case MUSHROOMER:
                final Set<Mushroomer> friends = ((Mushroomer)user).getFriends();
                return entityMapper.map(friends);

            case ADMIN:
                throw new UnsupportedOperationException(String.format("User type %s has no friends.", user.getRole()));

            default:
                throw new RuntimeException(String.format("Unhandled switch exception - %s", user.getRole()));
        }
    }

    @Override
    public Set<UserDto> findAll() {
        final List<User> users = userRepository.findAll();
        return entityMapper.map(users);
    }

    @Override
    public Set<UserDto> search(String value) {
        final Set<User> users = userRepository.findByUsernameIgnoreCaseContaining(value);
        return entityMapper.map(users);
    }

}
