package pl.polsl.mushrooms.application.model;

import org.springframework.security.core.authority.AuthorityUtils;
import pl.polsl.mushrooms.application.enums.UserRole;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 30.03.2017.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));

    }

    public User getUser() {
        return user;
    }

    public UUID getId() {
        return user.getId();
    }

    public UserRole getRole() {
        return user.getRole();
    }
}
