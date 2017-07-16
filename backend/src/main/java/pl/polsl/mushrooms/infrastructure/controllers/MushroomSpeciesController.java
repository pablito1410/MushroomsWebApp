package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.mushroom.species.CreateMushroomSpeciesCommand;
import pl.polsl.mushrooms.application.commands.mushroom.species.DeleteMushroomSpeciesCommand;
import pl.polsl.mushrooms.application.commands.mushroom.species.UpdateMushroomSpeciesCommand;
import pl.polsl.mushrooms.application.services.projections.MushroomSpeciesProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;
import pl.polsl.mushrooms.infrastructure.dto.MushroomSpeciesDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 27.06.2017.
 */
@RestController
@RequestMapping("/api/mushroom-species")
public class MushroomSpeciesController {

    private final CommandGateway commandGateway;
    private final MushroomSpeciesProjectionService mushroomSpeciesProjectionService;

    public MushroomSpeciesController(
            final CommandGateway commandGateway,
            final MushroomSpeciesProjectionService mushroomSpeciesProjectionService) {
        this.commandGateway = commandGateway;
        this.mushroomSpeciesProjectionService = mushroomSpeciesProjectionService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Long> create(@RequestBody CreateMushroomSpeciesCommand command) {
        final long id = commandGateway.dispatch(command);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomSpeciesDto>> search(@RequestParam(value = "value") String value) {
        final Set<MushroomSpeciesDto> mushroomSpeciess = mushroomSpeciesProjectionService.search(value);
        return new ResponseEntity<>(mushroomSpeciess, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<MushroomSpeciesDto> update(@RequestBody UpdateMushroomSpeciesCommand command) {
        final MushroomSpeciesDto mushroomSpecies = commandGateway.dispatch(command);
        return new ResponseEntity<>(mushroomSpecies, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(DeleteMushroomSpeciesCommand command) {
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomSpeciesDto>> getAll() {
        final Set<MushroomSpeciesDto> mushroomSpeciess = mushroomSpeciesProjectionService.findAll();
        return new ResponseEntity<>(mushroomSpeciess, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MushroomSpeciesDto> getById(@PathVariable(name = "id") long id) {
        final MushroomSpeciesDto mushroomSpecies = mushroomSpeciesProjectionService.findOne(id);
        return new ResponseEntity<>(mushroomSpecies, HttpStatus.OK);
    }
}
