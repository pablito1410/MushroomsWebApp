package pl.polsl.mushrooms.infrastructure.dao;

import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;

/**
 * Created by pawel_zaqkxkn on 30.03.2017.
 */
@Repository
public class UserDaoImpl implements UserDao {


    private final UserRepository repository;

    public UserDaoImpl(final UserRepository repository) {

        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User findOne(long id) {
        return repository.findOne(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public User findOneByUsername(String username) {
        return repository.findOneByUsername(username);
    }
}
