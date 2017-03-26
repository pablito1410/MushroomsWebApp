package pl.polsl.mushrooms.application.user;

import pl.polsl.mushrooms.application.user.entity.User;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public interface UserRepository {
    User save(User user);

    User load(String email);
}
