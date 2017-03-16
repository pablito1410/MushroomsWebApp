package pl.polsl.mushrooms.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.polsl.mushrooms.application.api.request.CreateUserRequest;
import pl.polsl.mushrooms.application.api.request.LogInRequest;
import pl.polsl.mushrooms.application.api.response.UserLogInResponse;
import pl.polsl.mushrooms.application.repository.MushroomsRepository;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
public class UserServiceImpl implements UserService {


    private final MushroomsRepository repo;

    @Autowired
    public UserServiceImpl(MushroomsRepository repo) {
        this.repo = repo;
    }

    @Override
    public UUID createUser(CreateUserRequest request) {
        return null;
    }

    @Override
    public UserLogInResponse logIn(LogInRequest request) {
        return null;
    }
}
