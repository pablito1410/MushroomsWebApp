package pl.polsl.mushrooms.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.user.entity.User;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@Repository
public interface UserJpaDao extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}
