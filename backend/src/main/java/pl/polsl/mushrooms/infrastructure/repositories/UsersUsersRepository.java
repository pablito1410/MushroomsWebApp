package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.UsersUsers;
import pl.polsl.mushrooms.application.model.UsersUsersId;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 28.06.2017.
 */
@Repository
@RepositoryRestResource(exported = false)
public interface UsersUsersRepository extends JpaRepository<UsersUsers, UsersUsersId> {

    UsersUsers findOne(UsersUsersId usersUsersId);

    @Query("SELECT f FROM UsersUsers uu, Mushroomer m, Mushroomer f " +
            "WHERE ((uu.usersUsersId.user.id = m.id AND uu.usersUsersId.friend.id = f.id)" +
            " OR (uu.usersUsersId.friend.id = m.id AND uu.usersUsersId.user.id = f.id))" +
            " AND uu.dateTime IS NOT NULL " +
            " AND m.id = :userId")
    Set<Mushroomer> findFriends(@Param("userId") long userId);

    @Query("SELECT f FROM UsersUsers uu, Mushroomer m, Mushroomer f " +
            "WHERE uu.usersUsersId.friend.id = m.id AND uu.usersUsersId.user.id = f.id" +
            " AND uu.dateTime IS NULL " +
            " AND m.id = :userId")
    Set<Mushroomer> findRequests(@Param("userId") long userId);

    @Query("SELECT f FROM UsersUsers uu, Mushroomer m, Mushroomer f " +
            "WHERE uu.usersUsersId.user.id = m.id AND uu.usersUsersId.friend.id = f.id" +
            " AND uu.dateTime IS NULL " +
            " AND m.id = :userId")
    Set<Mushroomer> findInvitations(@Param("userId") Long userId);
}
