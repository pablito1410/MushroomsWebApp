package pl.polsl.mushrooms.application.exceptions;

import java.io.Serializable;


public class EntityAlreadyExistException extends IllegalStateException implements Serializable {

    public EntityAlreadyExistException() { }

    public EntityAlreadyExistException(final String message)
    {
        super(message);
    }

    public EntityAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityAlreadyExistException(Throwable cause) {
        super(cause);
    }

}
