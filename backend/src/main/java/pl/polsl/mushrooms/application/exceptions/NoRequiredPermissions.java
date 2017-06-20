package pl.polsl.mushrooms.application.exceptions;

/**
 * Created by pawel_zaqkxkn on 16.06.2017.
 */
public class NoRequiredPermissions extends RuntimeException {
    public NoRequiredPermissions(String s) {
        super(s);
    }
}
