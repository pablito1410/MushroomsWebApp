package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.Tag;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 17.07.2017.
 */
@Repository
@RepositoryRestResource(exported = false)
public interface TagRepository extends JpaRepository<Tag, Long> {

    Set<TagDto> findByDiscoveryMushroomerId(long userId);

    Set<Tag> findByNameIgnoreCaseContaining(String value);
}
