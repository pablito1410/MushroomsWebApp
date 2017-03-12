package pl.polsl.mushrooms.server.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.mushrooms.server.application.entity.ImageEntity;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
public interface ImageJpaDao extends JpaRepository<ImageEntity, UUID> {
}
