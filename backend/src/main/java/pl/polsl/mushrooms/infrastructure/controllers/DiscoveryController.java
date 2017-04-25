package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.discovery.CreateCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteCommand;
import pl.polsl.mushrooms.application.commands.discovery.GetCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateCommand;
import pl.polsl.mushrooms.application.exceptions.EntityAlreadyExistException;
import pl.polsl.mushrooms.application.model.Discovery;
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
    public ResponseEntity<Void> create(@RequestBody CreateCommand command) {

        try {
            commandGateway.dispatch(command);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(EntityAlreadyExistException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UpdateCommand command) {

        commandGateway.dispatch(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET, params = "id")
    public ResponseEntity<Discovery> get(@RequestParam("id") String id) {

        final GetCommand command = new GetCommand(UUID.fromString(id));
        final Discovery discovery = commandGateway.dispatch(command);

        return new ResponseEntity<>(discovery, HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.DELETE, params = "id")
    public ResponseEntity<Void> delete(@RequestParam("id") String id) {

        final DeleteCommand command = new DeleteCommand(UUID.fromString(id));
        commandGateway.dispatch(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
