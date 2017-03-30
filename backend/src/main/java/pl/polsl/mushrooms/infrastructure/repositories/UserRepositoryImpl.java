package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.application.repositories.UserRepository;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 30.03.2017.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {


    private final UserJpaDao userRepo;

    public UserRepositoryImpl(final UserJpaDao userRepo) {

        this.userRepo = userRepo;
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findUser(UUID id) {
        return userRepo.findOne(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public Collection<User> findAllUsers(Sort sort) {
        return userRepo.findAll(sort);
    }
}
