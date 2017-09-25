package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.tag.CreateTagCommand;
import pl.polsl.mushrooms.application.commands.tag.DeleteTagCommand;
import pl.polsl.mushrooms.application.commands.tag.UpdateTagCommand;
import pl.polsl.mushrooms.application.services.projections.TagProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;
import pl.polsl.mushrooms.infrastructure.dto.DiscoveryDto;
import pl.polsl.mushrooms.infrastructure.dto.TagDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */
@RestController
@RequestMapping("/api/tags")
public class TagController {

    private final CommandGateway commandGateway;
    private final TagProjectionService tagProjectionService;

    public TagController(final CommandGateway commandGateway,
                         TagProjectionService TagProjectionService) {
        this.commandGateway = commandGateway;
        this.tagProjectionService = TagProjectionService;
    }

    /**
     * CREATE
     * @param command
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addTag(@RequestBody CreateTagCommand command) {
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
    public ResponseEntity<Void> update(@RequestBody UpdateTagCommand command) {
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
        final DeleteTagCommand command = new DeleteTagCommand(id);
        command.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * GET ALL
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Set<TagDto>> getAll() {
        final String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        final Set<TagDto> tags = tagProjectionService.findAll(userName);
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    /**
     * GET BY ID
     * @param id
     * @return
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TagDto> getById(@PathVariable(name = "id") long id) {
        final TagDto tag = tagProjectionService.findOne(id);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    /**
     * SEARCH
     * @param value
     * @return
     */
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public ResponseEntity<Set<TagDto>> search(@RequestParam(value = "value") String value) {
        final Set<TagDto> users = tagProjectionService.search(value);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     *
     * @param tagId - Id of the tag
     * @return discoveries referenced to the tag
     */
    @RequestMapping(path = "/discovery/{id}", method = RequestMethod.GET)
    public ResponseEntity<DiscoveryDto> discovery(@PathVariable(name = "id") long tagId) {
        final DiscoveryDto discovery = tagProjectionService.findDiscovery(tagId);
        return new ResponseEntity<>(discovery, HttpStatus.OK);
    }

}
