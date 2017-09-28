package pl.polsl.mushrooms.infrastructure.dao;

import pl.polsl.mushrooms.application.dao.FriendProjectionDao;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.repositories.UsersUsersRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Set;



public class FriendProjectionDaoImpl implements FriendProjectionDao {

    private final UserDao userDao;
    private final UsersUsersRepository usersUsersRepository;
    private final EntityMapper entityMapper;
    public FriendProjectionDaoImpl(final UserDao userDao, final UsersUsersRepository usersUsersRepository, final EntityMapper entityMapper) {
        this.userDao = userDao;
        this.usersUsersRepository = usersUsersRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Set<MushroomerDto> findAll() {
        return Collections.emptySet();
    }

    @Override
    public MushroomerDto findOne(final long id) {
        return null;
    }

    @Override
    public Set<MushroomerDto> search(final String value) {
        return Collections.emptySet();
    }

    @Override
    public Set<MushroomerDto> findAll(final String userName) {
        final User user = userDao.findOneByUsername(userName)
                .orElseThrow(EntityNotFoundException::new);

        Set<Mushroomer> friends = usersUsersRepository.findFriends(user.getId());
        return entityMapper.map(friends);
    }

    @Override
    public Set<MushroomerDto> findRequests(final String username) {
        final User user = userDao.findOneByUsername(username)
                .orElseThrow(EntityNotFoundException::new);

        Set<Mushroomer> invitations = usersUsersRepository.findRequests(user.getId());
        return entityMapper.map(invitations);
    }

    @Override
    public Set<MushroomerDto> findInvitations(final String username) {
        final User user = userDao.findOneByUsername(username)
                .orElseThrow(EntityNotFoundException::new);

        Set<Mushroomer> invitations = usersUsersRepository.findInvitations(user.getId());
        return entityMapper.map(invitations);
    }

    @Override
    public Set<MushroomerDto> search(final Long userId, final String value) {
        Set<Mushroomer> friends = usersUsersRepository.searchByFriendUserName(userId, value);
        return entityMapper.map(friends);
    }
}
