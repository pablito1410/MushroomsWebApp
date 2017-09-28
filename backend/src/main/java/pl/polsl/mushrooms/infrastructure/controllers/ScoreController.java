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
import pl.polsl.mushrooms.infrastructure.dto.ScoreDto;

import java.util.Set;



@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    private final CommandGateway commandGateway;
    private final ScoreProjectionService scoreProjectionService;

    public ScoreController(CommandGateway commandGateway, ScoreProjectionService scoreProjectionService) {
        this.commandGateway = commandGateway;
        this.scoreProjectionService = scoreProjectionService;
    }

    /**
     * CREATE
     * @param command
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addScore(@RequestBody AddScoreCommand command) {
        command.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * UPDATE
     * @param command
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UpdateScoreCommand command) {
        command.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * DELETE
     * @param id
     * @return
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable(name = "id") long id) {
        final DeleteScoreCommand command = new DeleteScoreCommand();
        command.setId(id);
        command.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * GET ALL
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Set<ScoreDto>> getAll() {
        final String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        final Set<ScoreDto> tags = scoreProjectionService.findAll(userName);
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    /**
     * GET BY ID
     * @param id
     * @return
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ScoreDto> getById(@PathVariable(name = "id") long id) {
        final ScoreDto trip = scoreProjectionService.findOne(id);
        return new ResponseEntity<>(trip, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return average of the discovery's scores
     */
    @RequestMapping(path = "/discovery/{id}", method = RequestMethod.GET)
    public ResponseEntity<Double> scoresAverge(@PathVariable(name = "id") long id) {
        final double scoresAverage = scoreProjectionService.discoveryScoresAverage(id);
        return new ResponseEntity<>(Double.valueOf(scoresAverage), HttpStatus.OK);
    }

}
