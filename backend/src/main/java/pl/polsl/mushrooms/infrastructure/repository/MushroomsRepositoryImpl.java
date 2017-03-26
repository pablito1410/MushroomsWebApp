package pl.polsl.mushrooms.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.MushroomsRepository;
import pl.polsl.mushrooms.application.user.entity.User;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@Repository
public class MushroomsRepositoryImpl implements MushroomsRepository {

    private final UserJpaDao userRepo;

    @Autowired
    public MushroomsRepositoryImpl(UserJpaDao userRepo) {

        this.userRepo = userRepo;
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User load(String email) {
        return userRepo.findByEmail(email);
    }

}
