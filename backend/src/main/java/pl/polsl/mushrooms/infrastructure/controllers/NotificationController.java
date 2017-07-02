package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.notification.CreateNotificationCommand;
import pl.polsl.mushrooms.application.commands.notification.UpdateNotificationCommand;
import pl.polsl.mushrooms.application.commands.trip.CreateTripCommand;
import pl.polsl.mushrooms.application.commands.trip.DeleteTripCommand;
import pl.polsl.mushrooms.application.commands.trip.JoinTripCommand;
import pl.polsl.mushrooms.application.commands.trip.UpdateTripCommand;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.services.projections.NotificationProjectionService;
import pl.polsl.mushrooms.application.services.projections.TripProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;
import pl.polsl.mushrooms.infrastructure.dto.NotificationDto;
import pl.polsl.mushrooms.infrastructure.dto.TripDto;

import java.util.Map;
import java.util.Set;

/**
 * Created by chythe on 2017-07-02.
 */
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final CommandGateway commandGateway;
    private final NotificationProjectionService notificationProjectionService;

    @Autowired
    public NotificationController(final CommandGateway commandGateway,
                                  final NotificationProjectionService notificationProjectionService) {
        this.commandGateway = commandGateway;
        this.notificationProjectionService = notificationProjectionService;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Long> create(@RequestBody CreateNotificationCommand command) {
        final long id = commandGateway.dispatch(command);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UpdateNotificationCommand command) {
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<NotificationDto> getById(
            @PathVariable(name = "id") long id,
            @RequestParam(value = "projection", required = false, defaultValue = "FULL") ProjectionDao.Projection projection) {
        final NotificationDto notification = notificationProjectionService.findOne(id, projection);
        return new ResponseEntity<>(notification, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Set<NotificationDto>> getAll(
            @RequestParam(value = "projection", required = false, defaultValue = "FULL") ProjectionDao.Projection projection) {
        final String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        final Set<NotificationDto> trips = notificationProjectionService.findAll(userName, projection);
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.DELETE, params = "id")
    public ResponseEntity<Void> delete(@RequestParam("id") long id) {
        final DeleteTripCommand command = new DeleteTripCommand(id);
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
