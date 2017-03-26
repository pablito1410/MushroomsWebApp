package pl.polsl.mushrooms.application.user.presentation;

import pl.polsl.mushrooms.application.user.defs.Gender;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class UserProfilePresentation {

    private UUID id;

    private String nick;
    private int age;
    private Gender gender;

    public UserProfilePresentation(final UUID id, String nick, int age, Gender gender) {
        this.id = id;
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
