package pl.polsl.mushrooms.infrastructure.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.polsl.mushrooms.application.tools.PasswordEncoder;


public class PasswordEncoderDefault implements PasswordEncoder {

    private final BCryptPasswordEncoder encoder;

    @Autowired
    public PasswordEncoderDefault(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }


    @Override
    public String encode(String password) {
        return encoder.encode(password);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}
