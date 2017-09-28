package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.mushrooms.application.commands.mushroom.order.CreateMushroomOrderCommand;
import pl.polsl.mushrooms.application.commands.mushroom.order.DeleteMushroomOrderCommand;
import pl.polsl.mushrooms.application.commands.mushroom.order.UpdateMushroomOrderCommand;
import pl.polsl.mushrooms.application.services.projections.MushroomOrderProjectionService;
import pl.polsl.mushrooms.infrastructure.commands.CommandGateway;
import pl.polsl.mushrooms.infrastructure.dto.MushroomOrderDto;

import java.util.Set;



@RestController
@RequestMapping("/api/mushroom-order")
public class MushroomOrderController {

    private final CommandGateway commandGateway;
    private final MushroomOrderProjectionService mushroomOrderProjectionService;

    public MushroomOrderController(
            final CommandGateway commandGateway,
            final MushroomOrderProjectionService mushroomOrderProjectionService) {
        this.commandGateway = commandGateway;
        this.mushroomOrderProjectionService = mushroomOrderProjectionService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Long> create(@RequestBody CreateMushroomOrderCommand command) {
        final long id = commandGateway.dispatch(command);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomOrderDto>> search(@RequestParam(value = "value") String value) {
        final Set<MushroomOrderDto> mushroomOrders = mushroomOrderProjectionService.search(value);
        return new ResponseEntity<>(mushroomOrders, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<MushroomOrderDto> update(@RequestBody UpdateMushroomOrderCommand command) {
        final MushroomOrderDto mushroomOrder = commandGateway.dispatch(command);
        return new ResponseEntity<>(mushroomOrder, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable(name = "id") long id) {
        final DeleteMushroomOrderCommand command = new DeleteMushroomOrderCommand(id);
        commandGateway.dispatch(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Set<MushroomOrderDto>> getAll() {
        final Set<MushroomOrderDto> mushroomOrders = mushroomOrderProjectionService.findAll();
        return new ResponseEntity<>(mushroomOrders, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MushroomOrderDto> getById(@PathVariable(name = "id") long id) {
        final MushroomOrderDto mushroomOrder = mushroomOrderProjectionService.findOne(id);
        return new ResponseEntity<>(mushroomOrder, HttpStatus.OK);
    }
}
