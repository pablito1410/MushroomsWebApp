package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.application.model.UsersUsers;
import pl.polsl.mushrooms.application.model.UsersUsersId;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UsersUsersRepository;

import java.util.Optional;

/**
 * Created by pawel_zaqkxkn on 30.03.2017.
 */
public class UserDaoImpl implements UserDao {


    private final UserRepository repository;
    private final UsersUsersRepository usersUsersRepository;

    public UserDaoImpl(UserRepository repository, UsersUsersRepository usersUsersRepository) {
        this.repository = repository;
        this.usersUsersRepository = usersUsersRepository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> findOne(long id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    @Override
    public Optional<User> findOneByEmail(final String email) {
        return Optional.ofNullable(repository.findByEmail(email));
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Optional<User> findOneByUsername(String username) {
        return Optional.ofNullable(repository.findOneByUsername(username));
    }

    @Override
    public Optional<UsersUsers> findRelationship(UsersUsersId usersUsersId) {
        return Optional.ofNullable(usersUsersRepository.findOne(usersUsersId));
    }
}
