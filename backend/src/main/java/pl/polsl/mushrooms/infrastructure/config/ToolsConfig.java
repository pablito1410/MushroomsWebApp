package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.polsl.mushrooms.application.tools.PasswordEncoder;
import pl.polsl.mushrooms.infrastructure.tools.PasswordEncoderDefault;

/**
 * Created by pawel_zaqkxkn on 30.07.2017.
 */

@Configuration
public class ToolsConfig {

    @Bean
    public PasswordEncoder passwordEncoder(final BCryptPasswordEncoder encoder) {
        return new PasswordEncoderDefault(encoder);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
