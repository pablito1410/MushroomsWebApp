package pl.polsl.mushrooms.application.user.entity;

import pl.polsl.mushrooms.application.user.defs.Gender;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
@Entity
@Table(name = "User")
public class User extends UserProfile {

    private String email;
    private String password;

    protected User() { super(); }

    public User(
            final String email,
            final String password,
            final String nick,
            final int age,
            final Gender gender) {

        super(nick, age, gender);

        this.email = email;
        this.password = password;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
