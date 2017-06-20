package pl.polsl.mushrooms.application.services;

import org.springframework.security.core.context.SecurityContextHolder;
import pl.polsl.mushrooms.application.commands.friend.AddFriendCommand;
import pl.polsl.mushrooms.application.commands.friend.DeleteFriendsCommand;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Mushroomer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by pawel_zaqkxkn on 23.05.2017.
 */
public class FriendServiceImpl implements FriendService {

    private final UserDao repo;

    public FriendServiceImpl(UserDao repo) {
        this.repo = repo;
    }

    @Override
    public Collection<Long> handle(AddFriendCommand command) {
        final String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        final Mushroomer user = (Mushroomer)repo.findOneByUsername(currentUsername);

        final Collection<Long> addedFriends = new ArrayList<>();

        for (long friendId : command.getFriendIds()) {
            final Mushroomer friend = (Mushroomer)repo.findOne(friendId);

            if (friend != null) {
                user.addFriend(friend);
                addedFriends.add(friend.getId());
            }
        }

        repo.save(user);

        return addedFriends;
    }

    @Override
    public Collection<Long> handle(DeleteFriendsCommand command) {
        final String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        final Mushroomer user = (Mushroomer)repo.findOneByUsername(currentUsername);

        final Collection<Long> removedFriends = new ArrayList<>();

        for (long friendId : command.getFriendIds()) {
            final Mushroomer friend = (Mushroomer)repo.findOne(friendId);

            if (friend != null) {
                if (user.removeFriend(friend)) {
                    removedFriends.add(friend.getId());
                }
            }
        }

        repo.save(user);

        return removedFriends;
    }
}
