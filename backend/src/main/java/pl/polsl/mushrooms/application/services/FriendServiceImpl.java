package pl.polsl.mushrooms.application.services;

import org.springframework.security.core.context.SecurityContextHolder;
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
        final String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        final Mushroomer user = (Mushroomer)repo.findOneByUsername(currentUsername);

        for (long friendId : command.getFriendIds()) {
            final Mushroomer friend = (Mushroomer)repo.findOne(friendId);
            user.addFriend(friend);
            friend.addFriend(user);
            repo.save(user);
            repo.save(friend);
        }
    }
}
