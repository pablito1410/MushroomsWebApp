package pl.polsl.mushrooms.application.tools;


public interface PasswordEncoder {

    String encode(String password);

    boolean matches(String rawPassword, String encodedPassword);
}
