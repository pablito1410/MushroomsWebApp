package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.mushrooms.application.commands.score.AddScoreCommand;
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
}
