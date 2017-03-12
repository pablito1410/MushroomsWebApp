package pl.polsl.mushrooms.server.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.server.application.repository.MushroomsRepository;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@Repository
public class MushroomsRepositoryImpl implements MushroomsRepository {

    private final UserJpaDao userRepo;
    private final ImageJpaDao imageRepo;

    @Autowired
    public MushroomsRepositoryImpl(UserJpaDao userRepo, ImageJpaDao imageRepo) {

        this.userRepo = userRepo;
        this.imageRepo = imageRepo;
    }
}
