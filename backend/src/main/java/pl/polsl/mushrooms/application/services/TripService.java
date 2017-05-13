package pl.polsl.mushrooms.application.services;

import pl.polsl.mushrooms.application.commands.trip.CreateTripCommand;
import pl.polsl.mushrooms.application.commands.trip.DeleteTripCommand;
import pl.polsl.mushrooms.application.commands.trip.UpdateTripCommand;

/**
 * Created by pawel_zaqkxkn on 24.04.2017.
 */
public interface TripService {

    void handle(CreateTripCommand command);

    void handle(UpdateTripCommand command);

    void handle(DeleteTripCommand command);
}
