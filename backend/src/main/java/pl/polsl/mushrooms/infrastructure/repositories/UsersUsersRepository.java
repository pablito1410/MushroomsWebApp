package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.UsersUsers;
import pl.polsl.mushrooms.application.model.UsersUsersId;

/**
 * Created by pawel_zaqkxkn on 28.06.2017.
 */
@Repository
public interface UsersUsersRepository extends JpaRepository<UsersUsers, UsersUsersId> {

    UsersUsers findOne(UsersUsersId usersUsersId);
}
