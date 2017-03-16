package pl.polsl.mushrooms.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.polsl.mushrooms.application.repository.MushroomsRepository;
import pl.polsl.mushrooms.application.service.ImageService;
import pl.polsl.mushrooms.application.service.ImageServiceImpl;
import pl.polsl.mushrooms.application.service.UserService;
import pl.polsl.mushrooms.application.service.UserServiceImpl;

import java.awt.*;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@Configuration
public class MushroomsServerConfig {

    @Bean
    public UserService userService(MushroomsRepository repo) {
        return new UserServiceImpl(repo);
    }

    @Bean
    public ImageService imageService(MushroomsRepository repo) {
        return new ImageServiceImpl(repo);
    }
}
