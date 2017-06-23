package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.discovery.AddScoreToDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.CreateDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateDiscoveryCommand;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.services.projections.DiscoveryProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;
import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;

import java.util.Map;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */

@RestController
@RequestMapping("/api/discoveries")
public class DiscoveryController {

    private final CommandGateway commandGateway;
    private final DiscoveryProjectionService discoveryProjectionService;

    @Autowired
    public DiscoveryController(
            final CommandGateway commandGateway, final DiscoveryProjectionService discoveryProjectionService) {
        this.commandGateway = commandGateway;
        this.discoveryProjectionService = discoveryProjectionService;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Long> create(@RequestBody CreateDiscoveryCommand command) {
        final long id = commandGateway.dispatch(command);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UpdateDiscoveryCommand command) {
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getById(
            @PathVariable(name = "id") long id,
            @RequestParam(value = "projection", required = false, defaultValue = "FULL") ProjectionDao.Projection projection) {
        final Map<String, Object> discovery = discoveryProjectionService.findOne(id, projection);
        return new ResponseEntity<>(discovery, HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.DELETE, params = "id")
    public ResponseEntity<Void> delete(@RequestParam("id") long id) {
        final DeleteDiscoveryCommand command = new DeleteDiscoveryCommand(id);
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Set<DiscoveryDto>> getAll(
            @RequestParam(value = "projection", required = false, defaultValue = "FULL") ProjectionDao.Projection projection) {
        final String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        final Set<DiscoveryDto> discoveries = discoveryProjectionService.findAll(userName, projection);
        return new ResponseEntity<>(discoveries, HttpStatus.OK);
    }

    @RequestMapping(path = "/add-score", method = RequestMethod.POST)
    public ResponseEntity<Void> addScore(@RequestBody AddScoreToDiscoveryCommand command) {
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
