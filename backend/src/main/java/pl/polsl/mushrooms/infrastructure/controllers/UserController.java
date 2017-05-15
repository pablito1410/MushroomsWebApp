package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
import pl.polsl.mushrooms.application.commands.user.DeleteUserCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateUserCommand;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.model.User;
import pl.polsl.mushrooms.application.services.projections.UserProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 31.03.2017.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserProjectionService userProjectionService;
    private final CommandGateway commandGateway;


    @Autowired
    public UserController(
            UserProjectionService userProjectionService, CommandGateway commandGateway) {
        this.userProjectionService = userProjectionService;
        this.commandGateway = commandGateway;
    }

    // TODO PK walidacja przy rejestracji
//    @InitBinder("form")
//    public void initBinder(WebDataBinder binder) {
//        binder.addValidators(userValidationService);
//    }

    /**
     * CREATE
     * @param command
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UUID> create(@RequestBody CreateUserCommand command) {
        final UUID id = commandGateway.dispatch(command);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    /**
     * READ
     * @param id
     * @return
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getById(
            @PathVariable(name = "id") UUID id,
            @RequestParam(value = "projection", required = false, defaultValue = "FULL") ProjectionDao.Projection projection) {
        final Map<String, Object> user = userProjectionService.findOne(id, projection);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * READ
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> getAll() {

        // TODO projection

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * UPDATE
     * @param command
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UpdateUserCommand command) {
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * DELETE
     * @param id
     * @return
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable(name = "id") UUID id) {

        final DeleteUserCommand command = new DeleteUserCommand(id);
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
