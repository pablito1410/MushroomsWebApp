package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.friend.AddFriendCommand;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Mushroomer;

/**
 * Created by pawel_zaqkxkn on 23.05.2017.
 */
public class FriendServiceImpl implements FriendService {

    private final UserDao repo;

    public FriendServiceImpl(UserDao repo) {
        this.repo = repo;
    }

    @Override
    public void handle(AddFriendCommand command) {
        final Mushroomer friend = (Mushroomer)repo.findOne(command.getFriendId());
        final Mushroomer user = (Mushroomer)repo.findOneByUsername(command.getUsername());
        user.addFriend(friend);
        repo.save(user);
    }
}
