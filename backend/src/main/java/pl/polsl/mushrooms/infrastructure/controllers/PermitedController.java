package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pawel_zaqkxkn on 30.03.2017.
 */
@RestController
public class PermitedController {

    @RequestMapping(path = "/login-error", method = RequestMethod.GET)
    public String error() {
        return "Create account";
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Yo bitch";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "Login page";
    }
}
