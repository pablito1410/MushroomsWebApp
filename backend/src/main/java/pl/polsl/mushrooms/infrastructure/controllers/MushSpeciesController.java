package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.services.projections.MushSpeciesProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;
import pl.polsl.mushrooms.infrastructure.dto.MushroomSpeciesDto;

import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 27.06.2017.
 */
@RestController
@RequestMapping("/api/mushroom-species")
public class MushSpeciesController {

    private final CommandGateway commandGateway;
    private final MushSpeciesProjectionService mushSpeciesProjectionService;

    public MushSpeciesController(CommandGateway commandGateway, MushSpeciesProjectionService mushSpeciesProjectionService) {
        this.commandGateway = commandGateway;
        this.mushSpeciesProjectionService = mushSpeciesProjectionService;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomSpeciesDto>> getAll() {
        final Set<MushroomSpeciesDto> mushroomSpecies = mushSpeciesProjectionService.findAll();
        return new ResponseEntity<>(mushroomSpecies, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MushroomSpeciesDto> getById(
            @PathVariable(name = "id") long id) {
        final MushroomSpeciesDto mushroomSpecies = mushSpeciesProjectionService.findOne(id);
        return new ResponseEntity<>(mushroomSpecies, HttpStatus.OK);
    }
}
