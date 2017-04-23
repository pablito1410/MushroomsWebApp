package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.User;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}
