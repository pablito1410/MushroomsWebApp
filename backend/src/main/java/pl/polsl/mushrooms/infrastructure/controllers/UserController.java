package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.CreateUserCommand;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;
import pl.polsl.mushrooms.infrastructure.commands.UserValidatorService;

/**
 * Created by pawel_zaqkxkn on 31.03.2017.
 */
@RestController
@RequestMapping("mushrooms/api/1.0/user")
public class UserController {

    private final CommandGateway commandGateway;
    private final UserValidatorService userValidatorService;


    @Autowired
    public UserController(UserValidatorService userValidatorService, CommandGateway commandGateway) {
        this.userValidatorService = userValidatorService;
        this.commandGateway = commandGateway;
    }

    // TODO PK walidacja przy rejestracji
    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidatorService);
    }


    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody CreateUserCommand command) {

        final User userProfile = commandGateway.dispatch(command);

        if (userProfile == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userProfile, HttpStatus.ACCEPTED);
    }

}
