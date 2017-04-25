package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<UUID> create() {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }


    @RequestMapping(path = "/", method = RequestMethod.GET, params = "id")
    public ResponseEntity<Void> get(@RequestParam("id") String id) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public ResponseEntity<Void> update() {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete() {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
