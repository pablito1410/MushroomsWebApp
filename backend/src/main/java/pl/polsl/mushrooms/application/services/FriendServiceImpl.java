package pl.polsl.mushrooms.application.services;

import org.springframework.transaction.annotation.Transactional;
import pl.polsl.mushrooms.application.commands.friend.AcceptInvitationToFriendsCommand;
import pl.polsl.mushrooms.application.commands.friend.AddFriendCommand;
import pl.polsl.mushrooms.application.commands.friend.DeleteFriendsCommand;
import pl.polsl.mushrooms.application.dao.NotificationDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.enums.NotificationType;
import pl.polsl.mushrooms.application.exceptions.EntityAlreadyExistException;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.User;
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
    private final NotificationDao notificationDao;

    public FriendServiceImpl(
            final UserDao repo,
            final NotificationDao notificationDao) {
        this.repo = repo;
        this.notificationDao = notificationDao;
    }

    @Transactional
    @Override
    public Collection<Long> handle(AddFriendCommand command) {
        final String currentUsername = command.getUserName();
        final Mushroomer user = (Mushroomer)repo.findOneByUsername(currentUsername)
                    .orElseThrow(EntityNotFoundException::new);

        final Collection<Long> addedFriends = new ArrayList<>();

        for (long friendId : command.getFriendIds()) {
                final Optional<User> friend = repo.findOne(friendId);
                if (friend.isPresent() && friend.get().isMushroomer()) {
                    addFriend(user, (Mushroomer) friend.get());
                    addedFriends.add(friendId);
                }
                else {
                    // log
                }

        }

        repo.save(user);

        return addedFriends;
    }

    private void addFriend(final Mushroomer user, final Mushroomer newFriend) {
        if (user.hasFriend(newFriend)) {
            throw new EntityAlreadyExistException();
        } else if (newFriend.hasFriend(user)) {
            acceptInvitationToFriends(user, newFriend);
            acceptInvitationToFriends(newFriend, user);
            notificationDao.save(
                    newFriend.addNotification(user.getId(), NotificationType.FRIEND_ACCEPTING, user));
        } else {
            user.addFriend(newFriend);
            newFriend.addFriend(user);
            notificationDao.save(
                    newFriend.addNotification(user.getId(), NotificationType.FRIEND_INVITATION, user));
            repo.save(user);
            repo.save(newFriend);
        }
    }

    @Override
    public Collection<Long> handle(DeleteFriendsCommand command) {
        final String currentUsername = command.getUserName();
        final Mushroomer user = (Mushroomer)repo.findOneByUsername(currentUsername)
                    .orElseThrow(EntityNotFoundException::new);

        final Collection<Long> removedFriends = new ArrayList<>();

        for (long friendId : command.getFriendIds()) {
            final Optional<User> friend = repo.findOne(friendId);

            if (friend.isPresent() && friend.get().isMushroomer()) {
                final Mushroomer mushroomer = (Mushroomer) friend.get();
                if (user.removeFriend(mushroomer)) {
                    removedFriends.add(mushroomer.getId());
                }
            }
        }

        repo.save(user);

        return removedFriends;
    }

    @Override
    public void handle(AcceptInvitationToFriendsCommand command) {
        final String currentUsername = command.getUserName();
        final Mushroomer user = (Mushroomer)repo.findOneByUsername(currentUsername)
                    .orElseThrow(EntityNotFoundException::new);

        final User friend =
                repo.findOne(command.getFriendId())
                    .orElseThrow(EntityNotFoundException::new);

        if (friend.isMushroomer() && ((Mushroomer)friend).hasFriend(user)) {
            acceptInvitationToFriends(user, (Mushroomer)friend);
            acceptInvitationToFriends(((Mushroomer)friend), user);
            ((Mushroomer)friend).addNotification(user.getId(), NotificationType.FRIEND_ACCEPTING, user);
        } else {
            throw new EntityNotFoundException();
        }

        repo.save(user);
        repo.save(friend);
    }

    private void  acceptInvitationToFriends(Mushroomer user, Mushroomer friend) {
        final UsersUsersId usersUsersId = new UsersUsersId(friend, user);
        final UsersUsers relationship = repo.findRelationship(usersUsersId)
                .orElseThrow(EntityNotFoundException::new);
        relationship.setDateTime(LocalDateTime.now());
    }
}
