package pl.polsl.mushrooms.application.exceptions;


public class NoRequiredPermissions extends RuntimeException {
    public NoRequiredPermissions(String s) {
        super(s);
    }

    public NoRequiredPermissions() { super(); }
}
