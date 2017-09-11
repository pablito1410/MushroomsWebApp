package pl.polsl.mushrooms.application.tools;

/**
 * Created by pawel_zaqkxkn on 30.07.2017.
 */
public interface PasswordEncoder {

    String encode(String password);

    boolean matches(String rawPassword, String encodedPassword);
}
