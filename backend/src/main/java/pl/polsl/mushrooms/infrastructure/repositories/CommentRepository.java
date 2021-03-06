package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.Comment;

import java.util.Set;


@Repository
@RepositoryRestResource(exported = false)
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Set<Comment> findByContentIgnoreCaseContaining(String value);
}
