package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.application.model.UsersUsers;
import pl.polsl.mushrooms.application.model.UsersUsersId;

import java.util.Optional;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface UserDao {
    User save(User user);

    Optional<User> findOne(long id);

    Optional<User> findOneByEmail(String email);

    void delete(long id);

    Optional<User> findOneByUsername(String username);

    UsersUsers findRelationship(UsersUsersId usersUsersId);
}
