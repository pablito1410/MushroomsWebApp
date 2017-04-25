package pl.polsl.mushrooms.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.polsl.mushrooms.application.commands.CreateUserCommand;

/**
 * Created by pawel_zaqkxkn on 30.03.2017.
 */
@Component
public class UserValidationService implements Validator {

    private final UserService userService;

    @Autowired
    public UserValidationService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(CreateUserCommand.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateUserCommand form = (CreateUserCommand) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
    }

    private void validatePasswords(Errors errors, CreateUserCommand form) {
        if (!form.getPassword().equals(form.getPassword())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    private void validateEmail(Errors errors, CreateUserCommand form) {
        if (userService.getUserByEmail(form.getEmail()).isPresent()) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }

}