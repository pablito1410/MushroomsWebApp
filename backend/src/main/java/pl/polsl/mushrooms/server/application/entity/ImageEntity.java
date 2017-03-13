package pl.polsl.mushrooms.server.application.entity;

import pl.polsl.mushrooms.server.infrastructure.repository.ImageJpaDao;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@Entity
public class ImageEntity {

    @Id
    UUID id;

    private ImageEntity() { }
}
