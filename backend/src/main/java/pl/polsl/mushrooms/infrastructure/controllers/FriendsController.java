package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.friend.AddFriendCommand;
import pl.polsl.mushrooms.application.dao.ProjectionDao;
import pl.polsl.mushrooms.application.services.projections.UserProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;

import java.util.List;
import java.util.Map;

/**
 * Created by pawel_zaqkxkn on 23.05.2017.
 */
@RestController
@RequestMapping("/api/friends")
public class FriendsController {

    private final UserProjectionService userProjectionService;
    private final CommandGateway commandGateway;


    @Autowired
    public FriendsController(
            UserProjectionService userProjectionService, CommandGateway commandGateway) {
        this.userProjectionService = userProjectionService;
        this.commandGateway = commandGateway;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addFriend(@RequestBody AddFriendCommand command) {
        command.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Map<String,Object>>> getAll(
            @RequestParam(value = "projection", required = false, defaultValue = "FULL") ProjectionDao.Projection projection) {
        final String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        final List<Map<String,Object>> users = userProjectionService.findAll(userName, projection);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
