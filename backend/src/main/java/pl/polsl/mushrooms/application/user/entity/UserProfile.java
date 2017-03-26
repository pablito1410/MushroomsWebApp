package pl.polsl.mushrooms.application.user.entity;

import pl.polsl.mushrooms.application.user.defs.Gender;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nick;
    private int age;
    private Gender gender;

    protected UserProfile() { }

    public UserProfile(String nick, int age, Gender gender) {
        this.nick = nick;
        this.age = age;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
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
}
