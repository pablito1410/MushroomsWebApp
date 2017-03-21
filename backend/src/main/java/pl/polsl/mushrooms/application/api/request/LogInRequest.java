package pl.polsl.mushrooms.application.api.request;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
public class LogInRequest {

    private String email;
    private String password;

    public LogInRequest() { }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
