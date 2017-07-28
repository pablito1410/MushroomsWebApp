package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.mushroom.clazz.CreateMushroomClassCommand;
import pl.polsl.mushrooms.application.commands.mushroom.clazz.DeleteMushroomClassCommand;
import pl.polsl.mushrooms.application.commands.mushroom.clazz.UpdateMushroomClassCommand;
import pl.polsl.mushrooms.application.services.projections.MushroomClassProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;
import pl.polsl.mushrooms.infrastructure.dto.MushroomClassDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */

@RestController
@RequestMapping("/api/mushroom-class")
public class MushroomClassController {

    private final CommandGateway commandGateway;
    private final MushroomClassProjectionService mushroomClassProjectionService;

    @Autowired
    public MushroomClassController(
            final CommandGateway commandGateway,
            final MushroomClassProjectionService mushroomClassProjectionService) {
        this.commandGateway = commandGateway;
        this.mushroomClassProjectionService = mushroomClassProjectionService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Long> create(@RequestBody CreateMushroomClassCommand command) {
        final long id = commandGateway.dispatch(command);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomClassDto>> search(@RequestParam(value = "value") String value) {
        final Set<MushroomClassDto> mushroomClasses = mushroomClassProjectionService.search(value);
        return new ResponseEntity<>(mushroomClasses, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<MushroomClassDto> update(@RequestBody UpdateMushroomClassCommand command) {
        final MushroomClassDto mushroomClass = commandGateway.dispatch(command);
        return new ResponseEntity<>(mushroomClass, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable(name = "id") long id) {
        final DeleteMushroomClassCommand command = new DeleteMushroomClassCommand(id);
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomClassDto>> getAll() {
        final Set<MushroomClassDto> mushroomClasses = mushroomClassProjectionService.findAll();
        return new ResponseEntity<>(mushroomClasses, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MushroomClassDto> getById(@PathVariable(name = "id") long id) {
        final MushroomClassDto mushroomClass = mushroomClassProjectionService.findOne(id);
        return new ResponseEntity<>(mushroomClass, HttpStatus.OK);
    }
}
