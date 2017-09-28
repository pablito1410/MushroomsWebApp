package pl.polsl.mushrooms.application.dao;

import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.application.model.UsersUsers;
import pl.polsl.mushrooms.application.model.UsersUsersId;

import java.util.Optional;


public interface UserDao {
    User save(User user);

    Optional<User> findOne(long id);

    Optional<User> findOneByEmail(String email);

    void delete(long id);

    Optional<User> findOneByUsername(String username);

    Optional<UsersUsers> findRelationship(UsersUsersId usersUsersId);
}
