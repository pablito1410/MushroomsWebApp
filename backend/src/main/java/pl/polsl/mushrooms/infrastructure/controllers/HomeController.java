package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pawel_zaqkxkn on 31.03.2017.
 */
@RestController
public class HomeController {

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home() {
        return "Home page";
    }
}
