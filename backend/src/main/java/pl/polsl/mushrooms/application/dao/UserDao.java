package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.User;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface UserDao {
    User save(User user);

    User findOne(long id);

    User findUserByEmail(String email);

    void delete(long id);

    User findOneByUsername(String username);
}
