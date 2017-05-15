package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.trip.CreateTripCommand;
import pl.polsl.mushrooms.application.commands.trip.DeleteTripCommand;
import pl.polsl.mushrooms.application.commands.trip.UpdateTripCommand;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.services.projections.TripProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;

import java.util.Map;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
@RestController
@RequestMapping("/api/trips")
public class TripController {

    private final CommandGateway commandGateway;
    private final TripProjectionService tripProjectionService;

    @Autowired
    public TripController(final CommandGateway commandGateway, final TripProjectionService tripProjectionService) {
        this.commandGateway = commandGateway;
        this.tripProjectionService = tripProjectionService;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<UUID> create(@RequestBody CreateTripCommand command) {
        final UUID id = commandGateway.dispatch(command);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UpdateTripCommand command) {
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getById(
            @PathVariable(name = "id") UUID id,
            @RequestParam(value = "projection", required = false, defaultValue = "FULL") ProjectionDao.Projection projection) {
        final Map<String, Object> trip = tripProjectionService.findOne(id, projection);
        return new ResponseEntity<>(trip, HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.DELETE, params = "id")
    public ResponseEntity<Void> delete(@RequestParam("id") String id) {
        final DeleteTripCommand command = new DeleteTripCommand(UUID.fromString(id));
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
