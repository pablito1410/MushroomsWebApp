package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.Commentable;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */

@Repository
public interface CommentRepository extends JpaRepository<Commentable, UUID> {
}
