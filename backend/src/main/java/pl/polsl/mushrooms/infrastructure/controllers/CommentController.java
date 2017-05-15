package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.comment.CreateCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.DeleteCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.UpdateCommentCommand;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.exceptions.EntityAlreadyExistException;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommandGateway commandGateway;

    @Autowired
    public CommentController(final CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody CreateCommentCommand command) {

        try {
            commandGateway.dispatch(command);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(EntityAlreadyExistException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UpdateCommentCommand command) {

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

        final DeleteCommentCommand command = new DeleteCommentCommand(UUID.fromString(id));
        commandGateway.dispatch(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
