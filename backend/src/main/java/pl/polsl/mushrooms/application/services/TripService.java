package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.AddUserToTripCommand;
import pl.polsl.mushrooms.application.commands.CreateTripCommand;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public interface TripService {

    void handle(CreateTripCommand command);

    void handle(AddUserToTripCommand command);
}
