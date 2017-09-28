package pl.polsl.mushrooms.application.model;



import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class UsersUsersId implements Serializable {

    @ManyToOne(optional =  false, targetEntity = User.class)
    @JoinColumn(name = "\"USER_ID\"")
    private User user;

    @ManyToOne(optional = false, targetEntity = User.class)
    @JoinColumn(name = "\"FRIEND_ID\"")
    private User friend;

    protected UsersUsersId() { }

    public UsersUsersId(Mushroomer user, Mushroomer friend) {
        this.user = user;
        this.friend = friend;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
}
