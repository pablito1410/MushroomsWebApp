package pl.polsl.mushrooms.application.services;

import org.springframework.transaction.annotation.Transactional;
import pl.polsl.mushrooms.application.commands.friend.AcceptInvitationToFriendsCommand;
import pl.polsl.mushrooms.application.commands.friend.AddFriendCommand;
import pl.polsl.mushrooms.application.commands.friend.DeleteFriendsCommand;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.enums.NotificationType;
import pl.polsl.mushrooms.application.exceptions.EntityAlreadyExistException;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.UsersUsers;
import pl.polsl.mushrooms.application.model.UsersUsersId;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by pawel_zaqkxkn on 23.05.2017.
 */
@Transactional
public class FriendServiceImpl implements FriendService {

    private final UserDao repo;

    public FriendServiceImpl(UserDao repo) {
        this.repo = repo;
    }

    @Override
    public Collection<Long> handle(AddFriendCommand command) {
        final String currentUsername = command.getUserName();
        final Mushroomer user = Optional.ofNullable(
                (Mushroomer)repo.findOneByUsername(currentUsername))
                    .orElseThrow(EntityNotFoundException::new);

        final Collection<Long> addedFriends = new ArrayList<>();

        for (long friendId : command.getFriendIds()) {
            final Mushroomer friend = (Mushroomer)repo.findOne(friendId);

            if (user.hasFriend(friend)) {
                throw new EntityAlreadyExistException();
            } else if (friend.hasFriend(user)) {
                acceptInvitationToFriends(user, friend);
                friend.addNotification(user.getId(), NotificationType.FRIEND_ACCEPTING, user);
            } else {
                user.addFriend(friend);
                friend.addNotification(user.getId(), NotificationType.FRIEND_INVITATION, user);
                repo.save(friend);
                addedFriends.add(friend.getId());
            }
        }

        repo.save(user);

        return addedFriends;
    }

    @Override
    public Collection<Long> handle(DeleteFriendsCommand command) {
        final String currentUsername = command.getUserName();
        final Mushroomer user = Optional.ofNullable(
                (Mushroomer)repo.findOneByUsername(currentUsername))
                    .orElseThrow(EntityNotFoundException::new);

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

    @Override
    public void handle(AcceptInvitationToFriendsCommand command) {
        final String currentUsername = command.getUserName();
        final Mushroomer user = Optional.ofNullable(
                (Mushroomer)repo.findOneByUsername(currentUsername))
                    .orElseThrow(EntityNotFoundException::new);

        final Mushroomer friend = Optional.ofNullable(
                (Mushroomer)repo.findOne(command.getFriendId()))
                    .orElseThrow(EntityNotFoundException::new);

        if (friend.hasFriend(user)) {
            acceptInvitationToFriends(user, friend);
            friend.addNotification(user.getId(), NotificationType.FRIEND_ACCEPTING, user);
        } else {
            throw new EntityNotFoundException();
        }

        repo.save(user);
        repo.save(friend);
    }

    private void acceptInvitationToFriends(Mushroomer user, Mushroomer friend) {
        user.addFriend(friend);
        final UsersUsersId usersUsersId = new UsersUsersId(user, friend);
        final UsersUsers relationship = repo.findRelationship(usersUsersId);
        relationship.setDateTime(LocalDateTime.now());
    }
}
