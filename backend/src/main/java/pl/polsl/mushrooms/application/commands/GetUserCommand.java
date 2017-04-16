package pl.polsl.mushrooms.application.commands;

import pl.polsl.mushrooms.application.model.UserProfile;

/**
 * Created by pawel_zaqkxkn on 17.04.2017.
 */
public class GetUserCommand implements ReturningCommand<UserProfile> {

    private long id;

    private GetUserCommand() { }

    public GetUserCommand(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
