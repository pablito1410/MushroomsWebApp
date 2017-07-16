package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.mushroom.genus.CreateMushroomGenusCommand;
import pl.polsl.mushrooms.application.commands.mushroom.genus.DeleteMushroomGenusCommand;
import pl.polsl.mushrooms.application.commands.mushroom.genus.UpdateMushroomGenusCommand;
import pl.polsl.mushrooms.application.services.projections.MushroomGenusProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;
import pl.polsl.mushrooms.infrastructure.dto.MushroomGenusDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 16.07.2017.
 */

@RestController
@RequestMapping("/api/mushroom-genus")
public class MushroomGenusController {

    private final CommandGateway commandGateway;
    private final MushroomGenusProjectionService mushroomGenusProjectionService;

    @Autowired
    public MushroomGenusController(
            final CommandGateway commandGateway,
            final MushroomGenusProjectionService mushroomGenusProjectionService) {
        this.commandGateway = commandGateway;
        this.mushroomGenusProjectionService = mushroomGenusProjectionService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Long> create(@RequestBody CreateMushroomGenusCommand command) {
        final long id = commandGateway.dispatch(command);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomGenusDto>> search(@RequestParam(value = "value") String value) {
        final Set<MushroomGenusDto> mushroomGenuses = mushroomGenusProjectionService.search(value);
        return new ResponseEntity<>(mushroomGenuses, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<MushroomGenusDto> update(@RequestBody UpdateMushroomGenusCommand command) {
        final MushroomGenusDto mushroomGenus = commandGateway.dispatch(command);
        return new ResponseEntity<>(mushroomGenus, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(DeleteMushroomGenusCommand command) {
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomGenusDto>> getAll() {
        final Set<MushroomGenusDto> mushroomGenuses = mushroomGenusProjectionService.findAll();
        return new ResponseEntity<>(mushroomGenuses, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MushroomGenusDto> getById(@PathVariable(name = "id") long id) {
        final MushroomGenusDto mushroomGenus = mushroomGenusProjectionService.findOne(id);
        return new ResponseEntity<>(mushroomGenus, HttpStatus.OK);
    }
}
