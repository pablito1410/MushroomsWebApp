package pl.polsl.mushrooms.application.services;

import org.springframework.data.domain.Sort;
import pl.polsl.mushrooms.application.commands.*;
import pl.polsl.mushrooms.application.dao.UserDao;
import pl.polsl.mushrooms.application.exceptions.EntityAlreadyExistException;
import pl.polsl.mushrooms.application.model.Mushroomer;
import pl.polsl.mushrooms.application.model.User;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class UserServiceImpl implements UserService {


    private final UserDao repo;

    public UserServiceImpl(UserDao repo) {

        this.repo = repo;
    }

    @Override
    public UUID handle(CreateUserCommand command) {
        if (userExist(command.getEmail())) {
            throw new EntityAlreadyExistException("User with an e-mail = " + command.getEmail() + " already exist.");
        }

        final Mushroomer user = new Mushroomer(
                command.getUsername(),
                command.getEmail(),
                command.getPassword(),
                command.getRole()
        );

        repo.save(user);

        return user.getId();
    }

    @Override
    public User handle(GetUserCommand command) {

        Optional<User> user = Optional.ofNullable(repo.findUser(command.getId()));

        if (user.isPresent()) {
//            return new UserProfile(
//                    user.get().getId(),
//                    user.get().getNick(),
//                    user.get().getEmail(),
//                    user.get().getAge(),
//                    user.get().getGender(),
//                    user.get().getRole()
//            );
            return user.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(repo.findUserByEmail(email));
    }

    @Override
    public Collection<User> handle(GetAllUsersCommand command) {
        return repo.findAllUsers(new Sort("username"));
    }

    @Override
    public void handle(UpdateUserCommand updateUserCommand) {

    }

    @Override
    public void handle(DeleteUserCommand deleteUserCommand) {

    }

    private boolean userExist(final String email) {
        if (repo.findUserByEmail(email) == null) {
            return false;
        }
        else
        {
            return true;
        }
    }
}
