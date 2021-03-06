package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "\"USERS_USERS\"")
@AssociationOverrides({
        @AssociationOverride(name = "usersUsersId.user",
                joinColumns = @JoinColumn(name = "\"USER_ID\"")),
        @AssociationOverride(name = "usersUsersId.friend",
                joinColumns = @JoinColumn(name = "\"FRIEND_ID\"")) })
public class UsersUsers implements Serializable {

    @EmbeddedId
    private UsersUsersId usersUsersId;

    @Column(name = "\"DATE_TIME\"")
    private LocalDateTime dateTime;

    protected UsersUsers() { }

    public UsersUsers(UsersUsersId usersUsersId, LocalDateTime dateTime) {
        this.usersUsersId = usersUsersId;
        this.dateTime = dateTime;
    }

    public Long getUserId() {
        return usersUsersId.getUser().getId();
    }

    public Long getFriendId() {
        return usersUsersId.getFriend().getId();
    }

    public UsersUsersId getUsersUsersId() {
        return usersUsersId;
    }

    public void setUsersUsersId(UsersUsersId usersUsersId) {
        this.usersUsersId = usersUsersId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
