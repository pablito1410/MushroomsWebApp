package pl.polsl.mushrooms.application.dao;

import org.springframework.data.domain.Sort;
import pl.polsl.mushrooms.application.model.User;

import java.util.Collection;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface UserDao {
    User save(User user);

    User findUser(Long id);

    User findUserByEmail(String email);

    Collection<User> findAllUsers(Sort sort);
}
