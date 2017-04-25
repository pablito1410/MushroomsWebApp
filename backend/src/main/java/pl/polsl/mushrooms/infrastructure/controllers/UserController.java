package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.user.*;
import pl.polsl.mushrooms.application.exceptions.EntityAlreadyExistException;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.application.services.UserValidationService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 31.03.2017.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final CommandGateway commandGateway;
    private final UserValidationService userValidationService;


    @Autowired
    public UserController(UserValidationService userValidationService, CommandGateway commandGateway) {
        this.userValidationService = userValidationService;
        this.commandGateway = commandGateway;
    }

    // TODO PK walidacja przy rejestracji
    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidationService);
    }


    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody CreateCommand command) {

        try {
            commandGateway.dispatch(command);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(EntityAlreadyExistException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


    @RequestMapping(path = "/", method = RequestMethod.GET, params = "id")
    public ResponseEntity<User> getById(@RequestParam("id") String id) {

        final GetCommand command = new GetCommand(UUID.fromString(id));
        final User userProfile = commandGateway.dispatch(command);
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> getAll() {

        final GetAllUsersCommand command = new GetAllUsersCommand();
        final Collection<User> users = commandGateway.dispatch(command);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UpdateCommand command) {

        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@RequestParam UUID id) {

        final DeleteCommand command = new DeleteCommand(id);
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // TODO PK Nie usuwać! Przyda się w przyszłości
//    @RequestMapping(path = "store-image", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public StoreImageResponse receiveImage(
//            @RequestParam("file") List<MultipartFile> files, @RequestParam("info") String info) {
//
//        ImageData imageData = new ImageData(files, info);
//        StoreImageResponse response = imageService.storeImage(imageData);
//
//        return response;
//    }

}
