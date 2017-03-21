package pl.polsl.mushrooms.application.api.response;

import org.apache.catalina.User;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
public class UserLogInResponse {

    private String email;
    private String name;
    private String surname;

    public UserLogInResponse(String email, String name, String surname) {
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    private UserLogInResponse() { }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
