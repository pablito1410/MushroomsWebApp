package pl.polsl.mushrooms.infrastructure.dao;

import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.application.model.UsersUsers;
import pl.polsl.mushrooms.application.model.UsersUsersId;
import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;
import pl.polsl.mushrooms.infrastructure.repositories.UsersUsersRepository;

/**
 * Created by pawel_zaqkxkn on 30.03.2017.
 */
@Repository
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

    @Override
    public UsersUsers findRelationship(UsersUsersId usersUsersId) {
        return usersUsersRepository.findOne(usersUsersId);
    }
}
