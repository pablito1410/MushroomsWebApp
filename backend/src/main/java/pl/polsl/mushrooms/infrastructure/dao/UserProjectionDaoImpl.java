package pl.polsl.mushrooms.infrastructure.dao;

import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;
import pl.polsl.mushrooms.infrastructure.repositories.UserProjectionRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by pawel_zaqkxkn on 01.05.2017.
 */
@Repository
public class UserProjectionDaoImpl implements UserProjectionDao {

    private final UserProjectionRepository userProjectionRepository;

    public UserProjectionDaoImpl(UserProjectionRepository userProjectionRepository) {

        this.userProjectionRepository = userProjectionRepository;
    }


    @Override
    public Map<String, Object> findOneByUsername(String username, Projection projection) {
        return userProjectionRepository.findOneByUsername(username, projection);
    }

    @Override
    public Map<String, Object> findOne(long id, Projection projection) {
        return userProjectionRepository.findOne(id, projection);
    }

    @Override
    public long getId(String userName) {
        return userProjectionRepository.getId(userName);
    }

    @Override
    public List<Map<String,Object>> findAll(long id, Projection projection) {
        return userProjectionRepository.findAll(id, projection);
    }

    @Override
    public List<Map<String, Object>> search(String value, Projection projection) {
        return userProjectionRepository.search(value, projection);
    }
}
