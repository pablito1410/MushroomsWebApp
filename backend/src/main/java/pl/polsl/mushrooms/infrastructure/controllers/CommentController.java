package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.comment.CreateCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.DeleteCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.UpdateCommentCommand;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.services.projections.CommentProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;

import java.util.Map;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommandGateway commandGateway;
    private final CommentProjectionService commentProjectionService;

    @Autowired
    public CommentController(
            final CommandGateway commandGateway, final CommentProjectionService commentProjectionService) {
        this.commandGateway = commandGateway;
        this.commentProjectionService = commentProjectionService;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<UUID> create(@RequestBody CreateCommentCommand command) {
        final UUID id = commandGateway.dispatch(command);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
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
        final Map<String, Object> comment = commentProjectionService.findOne(id, projection);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.DELETE, params = "id")
    public ResponseEntity<Void> delete(@RequestParam("id") String id) {
        final DeleteCommentCommand command = new DeleteCommentCommand(UUID.fromString(id));
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
