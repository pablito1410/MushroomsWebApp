package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.User;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findOneByUsername(String username);

    Set<User> findByUsernameIgnoreCaseContaining(String username);

}
