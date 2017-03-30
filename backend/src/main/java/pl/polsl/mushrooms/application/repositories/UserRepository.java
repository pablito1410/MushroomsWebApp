package pl.polsl.mushrooms.application.repositories;

import org.springframework.data.domain.Sort;
import pl.polsl.mushrooms.application.model.User;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface UserRepository {
    User save(User user);

    User findUser(UUID id);

    User findUserByEmail(String email);

    Collection<User> findAllUsers(Sort sort);
}
