package pl.polsl.mushrooms.infrastructure.dao;

import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;
import pl.polsl.mushrooms.infrastructure.repositories.UserProjectionRepository;

import java.util.Map;
import java.util.UUID;

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
    public Map<String, Object> findOne(UUID id, Projection projection) {
        return userProjectionRepository.findOne(id, projection);
    }
}
