package pl.polsl.mushrooms.application.model;

import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.application.enums.UserRole;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String email;
    private String password;
    private String nick;
    private int age;
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    protected User() { super(); }

    public User(String email, String password, String nick, int age, Gender gender, UserRole role) {
        this.email = email;
        this.password = password;
        this.nick = nick;
        this.age = age;
        this.gender = gender;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNick() {
        return nick;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public UserRole getRole() {
        return role;
    }
}
