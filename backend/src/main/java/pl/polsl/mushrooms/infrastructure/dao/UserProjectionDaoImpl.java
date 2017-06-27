package pl.polsl.mushrooms.infrastructure.dao;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;
import pl.polsl.mushrooms.application.model.Admin;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.AdminDto;
import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.dto.UserDto;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 01.05.2017.
 */
@Repository
public class UserProjectionDaoImpl implements UserProjectionDao {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public UserProjectionDaoImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional(readOnly = true)
    @Override
    public UserDto findOneByUsername(String username, Projection projection) {
        final Optional<User> user = Optional.ofNullable(userRepository.findOneByUsername(username));
        if (user.isPresent()) {
            return mapUserToDto(user.get());
        } else {
            throw new EntityNotFoundException("User not found");
        }
    }

    @Override
    public UserDto findOne(long id, Projection projection) {
        final Optional<User> user = Optional.ofNullable(userRepository.findOne(id));
        if (user.isPresent()) {
            return mapUserToDto(user.get());
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
    public Set<MushroomerDto> findAll(long id, ProjectionDao.Projection projection) {
        final User user = Optional.ofNullable(
                userRepository.findOne(id))
                .orElseThrow(EntityNotFoundException::new);

        switch(user.getRole()) {
            case MUSHROOMER:
                final Set<Mushroomer> friends = ((Mushroomer)user).getFriends();
                return modelMapper.map(friends, new TypeToken<HashSet<MushroomerDto>>() {}.getType());

            case ADMIN:
                throw new UnsupportedOperationException(String.format("User type %s has no friends.", user.getRole()));

            default:
                throw new RuntimeException(String.format("Unhandled switch exception - %s", user.getRole()));
        }
    }

    @Override
    public Set<MushroomerDto> search(String value, Projection projection) {
        final Set<? extends User> users = userRepository.findByUsernameIgnoreCaseContaining(value);
        return modelMapper.map(users, new TypeToken<HashSet<MushroomerDto>>() {}.getType());
    }

    private UserDto mapUserToDto(final User user) {
        Objects.requireNonNull(user);

        if (user instanceof Mushroomer) {
            return modelMapper.map((Mushroomer) user, MushroomerDto.class);
        } else if (user instanceof Admin) {
            return modelMapper.map((Admin) user, AdminDto.class);
        } else {
            throw new IllegalStateException("Unknown instanceof User class - " + user.getClass());
        }
    }
}
