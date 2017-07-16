package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.mushroom.family.CreateMushroomFamilyCommand;
import pl.polsl.mushrooms.application.commands.mushroom.family.DeleteMushroomFamilyCommand;
import pl.polsl.mushrooms.application.commands.mushroom.family.UpdateMushroomFamilyCommand;
import pl.polsl.mushrooms.application.services.projections.MushroomFamilyProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;
import pl.polsl.mushrooms.infrastructure.dto.MushroomFamilyDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */

@RestController
@RequestMapping("/api/mushroom-family")
public class MushroomFamilyController {

    private final CommandGateway commandGateway;
    private final MushroomFamilyProjectionService mushroomFamilyProjectionService;

    public MushroomFamilyController(
            final CommandGateway commandGateway,
            final MushroomFamilyProjectionService mushroomFamilyProjectionService) {
        this.commandGateway = commandGateway;
        this.mushroomFamilyProjectionService = mushroomFamilyProjectionService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Long> create(@RequestBody CreateMushroomFamilyCommand command) {
        final long id = commandGateway.dispatch(command);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomFamilyDto>> search(@RequestParam(value = "value") String value) {
        final Set<MushroomFamilyDto> mushroomFamilies = mushroomFamilyProjectionService.search(value);
        return new ResponseEntity<>(mushroomFamilies, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<MushroomFamilyDto> update(@RequestBody UpdateMushroomFamilyCommand command) {
        final MushroomFamilyDto mushroomFamily = commandGateway.dispatch(command);
        return new ResponseEntity<>(mushroomFamily, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(DeleteMushroomFamilyCommand command) {
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomFamilyDto>> getAll() {
        final Set<MushroomFamilyDto> mushroomFamilies = mushroomFamilyProjectionService.findAll();
        return new ResponseEntity<>(mushroomFamilies, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MushroomFamilyDto> getById(@PathVariable(name = "id") long id) {
        final MushroomFamilyDto mushroomFamily = mushroomFamilyProjectionService.findOne(id);
        return new ResponseEntity<>(mushroomFamily, HttpStatus.OK);
    }
}
