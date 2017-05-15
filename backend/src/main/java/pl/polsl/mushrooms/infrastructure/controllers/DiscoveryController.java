package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.discovery.CreateDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateDiscoveryCommand;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.exceptions.EntityAlreadyExistException;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */

@RestController
@RequestMapping("/api/discoveries")
public class DiscoveryController {

    private final CommandGateway commandGateway;

    @Autowired
    public DiscoveryController(final CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody CreateDiscoveryCommand command) {

        try {
            commandGateway.dispatch(command);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(EntityAlreadyExistException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UpdateDiscoveryCommand command) {

        commandGateway.dispatch(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(
            @PathVariable(name = "id") UUID id,
            @RequestParam(value = "projection", required = false, defaultValue = "FULL") ProjectionDao.Projection projection) {

        // TODO projection

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.DELETE, params = "id")
    public ResponseEntity<Void> delete(@RequestParam("id") String id) {

        final DeleteDiscoveryCommand command = new DeleteDiscoveryCommand(UUID.fromString(id));
        commandGateway.dispatch(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
