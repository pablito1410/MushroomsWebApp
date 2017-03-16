package pl.polsl.mushrooms.application.service;

import pl.polsl.mushrooms.application.api.request.CreateUserRequest;
import pl.polsl.mushrooms.application.api.request.LogInRequest;
import pl.polsl.mushrooms.application.api.response.UserLogInResponse;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
public interface UserService {
    
    UUID createUser(CreateUserRequest request);

    UserLogInResponse logIn(LogInRequest request);
}
