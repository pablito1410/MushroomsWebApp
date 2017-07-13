package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.score.AddScoreCommand;
import pl.polsl.mushrooms.application.commands.score.DeleteScoreCommand;
import pl.polsl.mushrooms.application.commands.score.UpdateScoreCommand;
import pl.polsl.mushrooms.application.services.projections.ScoreProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;

/**
 * Created by pawel_zaqkxkn on 26.06.2017.
 */

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    private final CommandGateway commandGateway;
    private final ScoreProjectionService scoreProjectionService;

    public ScoreController(CommandGateway commandGateway, ScoreProjectionService scoreProjectionService) {
        this.commandGateway = commandGateway;
        this.scoreProjectionService = scoreProjectionService;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> addScore(@RequestBody AddScoreCommand command) {
        command.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UpdateScoreCommand command) {
        command.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable(name = "id") long id) {
        final DeleteScoreCommand command = new DeleteScoreCommand();
        command.setId(id);
        command.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
