package pl.polsl.mushrooms.application.exceptions;

import java.io.Serializable;

/**
 * Created by pawel_zaqkxkn on 17.04.2017.
 */
public class UserAlreadyExistException extends IllegalStateException implements Serializable {

    public UserAlreadyExistException() { }

    public UserAlreadyExistException(final String message)
    {
        super(message);
    }

    public UserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistException(Throwable cause) {
        super(cause);
    }

}
