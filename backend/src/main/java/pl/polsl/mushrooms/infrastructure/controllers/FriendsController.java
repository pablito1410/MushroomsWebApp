package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.friend.AcceptInvitationToFriendsCommand;
import pl.polsl.mushrooms.application.commands.friend.AddFriendCommand;
import pl.polsl.mushrooms.application.commands.friend.DeleteFriendsCommand;
import pl.polsl.mushrooms.application.services.projections.FriendProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;
import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;

import java.util.Collection;
import java.util.Set;


@RestController
@RequestMapping("/api/friends")
public class FriendsController {

    private final FriendProjectionService friendsProjectionService;
    private final CommandGateway commandGateway;


    @Autowired
    public FriendsController(
            FriendProjectionService friendsProjectionService, CommandGateway commandGateway) {
        this.friendsProjectionService = friendsProjectionService;
        this.commandGateway = commandGateway;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Collection<Long>> addFriend(@RequestBody AddFriendCommand command) {
        command.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        Collection<Long> addedFriends = commandGateway.dispatch(command);
        return new ResponseEntity<>(addedFriends, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> acceptInvitation(@RequestBody AcceptInvitationToFriendsCommand command) {
        command.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomerDto>> getAll() {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        final Set<MushroomerDto> users = friendsProjectionService.findAll(username);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(path = "/requests", method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomerDto>> getRequests() {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        final Set<MushroomerDto> invitations = friendsProjectionService.findRequests(username);
        return new ResponseEntity<>(invitations, HttpStatus.OK);
    }

    @RequestMapping(path = "/invitations", method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomerDto>> getInvitations() {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        final Set<MushroomerDto> invitations = friendsProjectionService.findInvitations(username);
        return new ResponseEntity<>(invitations, HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Collection<Long>> delete(@RequestBody DeleteFriendsCommand command) {
        command.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        final Collection<Long> removedFriends = commandGateway.dispatch(command);
        return new ResponseEntity<>(removedFriends, HttpStatus.OK);
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomerDto>> search(@RequestParam(value = "value") String value) {
        final String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        final Set<MushroomerDto> users = friendsProjectionService.search(userName, value);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
