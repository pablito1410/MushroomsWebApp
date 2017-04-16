package pl.polsl.mushrooms.application.model;

import pl.polsl.mushrooms.application.enums.Gender;
import pl.polsl.mushrooms.application.enums.UserRole;

/**
 * Created by pawel_zaqkxkn on 17.04.2017.
 */
public class UserProfile {

    private long id;
    private String nick;
    private String email;
    private int age;
    private Gender gender;
    private UserRole role;

    public UserProfile(long id, String nick, String email, int age, Gender gender, UserRole role) {
        this.id = id;
        this.nick = nick;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
