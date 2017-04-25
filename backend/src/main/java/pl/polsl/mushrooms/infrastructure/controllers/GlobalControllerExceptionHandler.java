package pl.polsl.mushrooms.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.polsl.mushrooms.application.exceptions.EntityAlreadyExistException;

/**
 * Created by pawel_zaqkxkn on 25.04.2017.
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT) // 409
    @ExceptionHandler(EntityAlreadyExistException.class)
    public void handleConflict() {
        //
    }
}
