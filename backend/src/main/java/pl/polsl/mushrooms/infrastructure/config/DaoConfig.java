package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.polsl.mushrooms.application.dao.CommentDao;
import pl.polsl.mushrooms.infrastructure.dao.CommentDaoImpl;
import pl.polsl.mushrooms.infrastructure.repositories.CommentRepository;

/**
 * Created by pawel_zaqkxkn on 08.07.2017.
 */

@Configuration
public class DaoConfig {

    @Bean
    public CommentDao commentDao(final CommentRepository commentRepository) {
        return new CommentDaoImpl(commentRepository);
    }
}
